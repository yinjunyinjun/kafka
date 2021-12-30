package com.mycompany.kafka.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
@Slf4j
@Component
public class ControllerLogFilter {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private long start=0;
    private long end=0;

    @Pointcut("execution(* com.mycompany.kafka.controller.*.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        start=System.currentTimeMillis();
        StringBuffer sb=new StringBuffer("request:");
       // log.info("@Before通知执行");
        //获取目标方法参数信息
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg->{  // 大大
            try {
                sb.append(" args:"+OBJECT_MAPPER.writeValueAsString(arg));
                //log.info(OBJECT_MAPPER.writeValueAsString(arg));
            } catch (JsonProcessingException e) {
               // log.info(arg.toString());
                sb.append(arg.toString());
            }
        });
        //aop代理对象
        Object aThis = joinPoint.getThis();
      //  log.info(aThis.toString()); //com.xhx.springboot.controller.HelloController@69fbbcdd
        //被代理对象
        Object target = joinPoint.getTarget();
      //  log.info(target.toString()); //com.xhx.springboot.controller.HelloController@69fbbcdd
        //获取连接点的方法签名对象
        Signature signature = joinPoint.getSignature();
      //  log.info(signature.toLongString()); //public java.lang.String com.xhx.springboot.controller.HelloController.getName(java.lang.String)
       // log.info(signature.toShortString()); //HelloController.getName(..)
      //  log.info(signature.toString()); //String com.xhx.springboot.controller.HelloController.getName(String)
        //获取方法名
      //  log.info(signature.getName()); //getName
        sb.append("  method:"+signature.toString());
        //获取声明类型名
     //   log.info(signature.getDeclaringTypeName()); //com.xhx.springboot.controller.HelloController
        //获取声明类型  方法所在类的class对象
  //      log.info(signature.getDeclaringType().toString()); //class com.xhx.springboot.controller.HelloController
        //和getDeclaringTypeName()一样
     //   log.info(signature.getDeclaringType().getName());//com.xhx.springboot.controller.HelloController
        //连接点类型
        String kind = joinPoint.getKind();
    //    log.info(kind);//method-execution
        //返回连接点方法所在类文件中的位置  打印报异常
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
       // log.info(sourceLocation.toString());
        //log.info(sourceLocation.getFileName());
        //log.info(sourceLocation.getLine()+"");
        //log.info(sourceLocation.getWithinType().toString()); //class com.xhx.springboot.controller.HelloController
        ///返回连接点静态部分
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
       // log.info(staticPart.toLongString());  //execution(public java.lang.String com.xhx.springboot.controller.HelloController.getName(java.lang.String))
        //attributes可以获取request信息 session信息等
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        sb.append("  URL:"+request.getRequestURL().toString());
       // log.info(request.getRequestURL().toString()); //http://127.0.0.1:8080/hello/getName
      //  log.info(request.getRemoteAddr()); //127.0.0.1
        sb.append("   remoteIP:"+request.getRemoteAddr());
       // log.info(request.getMethod()); //GET
        sb.append("  requestType：:"+request.getMethod());
        log.info(sb.toString());
     //   log.info("before通知执行结束");
    }

    /**
     * 后置返回
     *      如果第一个参数为JoinPoint，则第二个参数为返回值的信息
     *      如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
     *            参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object result){
        end=System.currentTimeMillis();
        log.info("response:"+result+";耗时："+(end-start)+"ms");
    }


    /**
     * 后置异常通知
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     *            对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        log.info(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            log.info("发生了空指针异常!!!!!");
        }
    }

}
