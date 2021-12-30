package com.mycompany.kafka.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseController {
    public final Log logger = LogFactory.getLog(this.getClass());
//    @Autowired
//    private ResultUtil resultUtil;
//
//    public Map<String, Object> success() {
//        return resultUtil.success(null);
//    }
//
//    public Map success(Object body) {
//        return resultUtil.success(body);
//    }



    /**
     * 其他未处理的异常
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResponseEntity<Map> handleException(Exception e) {
//        logger.error(e);
//        logger.error(e.getCause());
//        Map innerResponseError = resultUtil.fail(e.getMessage(),"99999");
//        return new ResponseEntity<Map>(innerResponseError, HttpStatus.OK);
//    }


}
