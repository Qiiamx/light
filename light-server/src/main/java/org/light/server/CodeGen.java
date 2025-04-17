package org.light.server;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.dialect.IDialect;
import com.zaxxer.hikari.HikariDataSource;

public class CodeGen {
    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/postgres?currentSchema=light");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("org.postgresql.Driver");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();
        //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig, IDialect.POSTGRESQL);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();
        //设置根包
        globalConfig.setBasePackage("org.light.server.entity");

        //设置表前缀和只生成哪些表
//        globalConfig.setTablePrefix("tb_");
//        globalConfig.setGenerateTable("tb_account", "tb_account_session");

        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(false);
        globalConfig.setWithActiveRecord(true);
        //设置项目的JDK版本，项目的JDK为14及以上时建议设置该项，小于14则可以不设置
        globalConfig.setEntityJdkVersion(21);

        //设置生成 xml mapper service controller
        globalConfig.setMapperXmlGenerateEnable(false);
        globalConfig.setMapperGenerateEnable(false);
        globalConfig.setServiceGenerateEnable(false);
        globalConfig.setControllerGenerateEnable(false);

        //可以单独配置某个列
//        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }

}
