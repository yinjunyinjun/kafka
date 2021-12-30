import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    // 基础信息配置
    // 数据库连接字符
    private static final String URL = "jdbc:oracle:thin:@10.1.81.174:1521/fndb";
    // 数据库用户名
    private static final String USERNAME = "kafka";
    // 数据库密码
    private static final String PASSWORD = "kafka";
    // 项目根路径。生成结果如：D:\MyProject\spring-boot
    private static final String projectRootPath = System.getProperty("user.dir");
    // 项目根路径（测试用，非通用）（此句是本项目测试用的。实际项目中，包括多模块项目，请注释掉此句，使用上句）
//    private static final String projectRootPath = System.getProperty("user.dir") + "/study-mybatis-plus-fast-generator";
    // 父包名。用于生成的java文件的import。
//    private static final String parentPackageName = "com.cxhit.mybatisplus.generator";
    private static final String parentPackageName = "com.mycompany.kafka";


    public static void main(String ...a) throws Exception{
//        for(int i=0;i<100;i++){
//            System.out.println(IdWorker.get32UUID());
//            // 返回值 "1385106677482582019"
//            System.out.println(IdWorker.getIdStr());
//        }

        simpleGenerator();
     //   testJdbc();


    }
    /**
     * 【单模块】简单的实现方案
     */
    protected static void simpleGenerator() {

        // 包路径
        String packagePath = projectRootPath + "/src/main/java";
        // XML文件的路径
        String mapperXmlPath = projectRootPath + "/src/main/resources/mapper";

        // 开始执行代码生成
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 1. 全局配置
                .globalConfig(builder -> builder
                        // 作者名称
                        .author("尹君")
                        // 开启覆盖已生成的文件。注释掉则关闭覆盖。
                        // .fileOverride()
                        // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
                        .disableOpenDir()
                        // 指定输出目录。如果指定，Windows生成至D盘根目录下，Linux or MAC 生成至 /tmp 目录下。
                        .outputDir(packagePath)
                        // 开启swagger2.注释掉则默认关闭。
                        // .enableSwagger()
                        // 指定时间策略。
                        .dateType(DateType.TIME_PACK)
                        // 注释时间策略。
                        .commentDate("yyyy-MM-dd")
                )

                // 2. 包配置
                .packageConfig((scanner, builder) -> builder
                        // 设置父表名
                        .parent(parentPackageName)
                        .moduleName(scanner.apply("请输入模块名："))
                        // mapper.xml 文件的路径。单模块下，其他文件路径默认即可。
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, mapperXmlPath))
                )

                // 3. 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？生成所有表，请输入[all]：")))
                        // 阶段1：Entity实体类策略配置
                        .entityBuilder()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        // 逻辑删除字段名(数据库)。
                        .logicDeleteColumnName("is_delete")
                        // 逻辑删除属性名(实体)。
                        // 会在实体类的该字段属性前加注解[@TableLogic]
                        .logicDeletePropertyName("isDelete")
                        // 会在实体类的该字段上追加注解[@TableField(value = "create_time", fill = FieldFill.INSERT)]
                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        // 会在实体类的该字段上追加注解[@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)]
                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                        // 阶段2：Mapper策略配置
                        .mapperBuilder()
                        // 开启 @Mapper 注解。
                        // 会在mapper接口上添加注解[@Mapper]
                        .enableMapperAnnotation()
                        // 启用 BaseResultMap 生成。
                        // 会在mapper.xml文件生成[通用查询映射结果]配置。
                        .enableBaseResultMap()
                        // 启用 BaseColumnList。
                        // 会在mapper.xml文件生成[通用查询结果列 ]配置
                        .enableBaseColumnList()
                        // 阶段4：Controller策略配置
                        .controllerBuilder()
                        // 会在控制类中加[@RestController]注解。
                        .enableRestStyle()
                        // 开启驼峰转连字符
                        .enableHyphenStyle()
                        .build()
                )

                // 4. 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                //.templateEngine(new BeetlTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine())

                // 5. 执行
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

//    public static void testJdbc() throws Exception {
//        //1.加载驱动程序
//        Class.forName("oracle.jdbc.OracleDriver");
//        //2. 获得数据库连接
//        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        //3.操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM t_sys_user");
//        //如果有数据，rs.next()返回true
//        while(rs.next()){
//            System.out.println(rs.getInt("ID")+" 年龄："+rs.getString("NAME"));
//        }
//    }
//    public static void testJdbc() throws Exception {
//        //1.加载驱动程序
//        Class.forName("oracle.jdbc.OracleDriver");
//        //2. 获得数据库连接
//        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        //3.操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM t_sys_user");
//        //如果有数据，rs.next()返回true
//        while(rs.next()){
//            System.out.println(rs.getInt("ID")+" 年龄："+rs.getString("NAME"));
//        }
//    }


}
