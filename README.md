# Light
在线监察
三方实名认证 / 嫌疑人举报 / 多人审查 / 信用评级

计划开发内容

后端主要功能 √

前端交互 -

自动更新交付 -

# 技术结构

```
java 21: SDK
SpringBoot 3: 后端框架
SA-Token: 鉴权框架
Mybatis Flex: CRUD框架
PostgreSQL 17: 数据库
Redis: 缓存插件(暂未使用)
Vue 3: 前端框架(暂未使用)
待补充
```

# 项目结构
```
后端代码 更新中
light-server
    -org.light.server
        -api 接口定义目录,也是日志层(日志AOP还没加)
        -common 通用对象
        -config 组件配置(权限/数据库/线程/缓存等)
        -constant 全局静态变量
        -controller 接口实现层
        -dto 数据交互对象
        -entity 数据库对象
        -enums 全局枚举类
        -exception 异常处理
        -service 业务层
        -util 通用工具


light-ui
前端代码
```
