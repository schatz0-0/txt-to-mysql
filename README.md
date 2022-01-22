
分支 dev-1.0.1 说明

1、通过获取数据库的表信息来确定插入数据的字段名，入参数据类型为 string 时数据库会自动转换类型。

2、使用 spring shell 实现交互，动态链接数据库。


废弃文件或代码说明

1、application 的 dbshu 相关信息可以废弃，由数据库的表信息确定；

2、start 类废弃，由 CommandStart 类执行；

Shell 命令说明
```
通过 start.bat 启动 jar 后，在命令行输入以下命令

start --f C:\\Users\\Administrator\\Desktop\\test --ip 192.168.0.102 --d test --u root --p 123456 --t sea_test

start 是 shell 命令执行函数
--f 需要解析的文件目录 C:\\Users\\Administrator\\Desktop\\test  test目录下应包含需解析的文件 ctd2020-09-27.txt
--ip 数据库IP 192.168.0.102
--d 数据库名 test
--u 数据库用户名 root
--p 数据库用户密码 123456
--t 数据库表名 sea_test
```

测试环境说明

测试环境数据库： MySQL-5.7.30 ，若使用 8.0 需要修改 application配置的驱动、CommandStart.toStart方法的url、pom.xml mysql包；

数据库表结构

数据表：sea_test  年月日时分秒为varchar，其他字段为decimal

```
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for sea_test
-- ----------------------------
DROP TABLE IF EXISTS `sea_test`;
CREATE TABLE `sea_test`  (
`id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
`年月日时分秒` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`电导率` decimal(18, 6) NULL DEFAULT 0.000000,
`盐度（psu）` decimal(18, 6) NULL DEFAULT 0.000000,
`温度（℃）` decimal(18, 6) NULL DEFAULT 0.000000,
`深度（m）` decimal(18, 6) NULL DEFAULT 0.000000,
`叶绿素（mg/L）` decimal(18, 6) NULL DEFAULT 0.000000,
`浊度（NTU）` decimal(18, 6) NULL DEFAULT 0.000000,
`PH（ph）` decimal(18, 6) NULL DEFAULT 0.000000,
`溶解氧` decimal(18, 6) NULL DEFAULT 0.000000,
`声速` decimal(18, 6) NULL DEFAULT 0.000000,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```