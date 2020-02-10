## 注意事项

* 配置文件需要参考如下配置

```
rjgf:
  # live 配置
  hive:
    url: jdbc:hive2://192.168.110.221:10000/default
    driver-class-name: org.apache.hive.jdbc.HiveDriver
    username: hdfs
  #  password: hadoop

  # impala 集群 别名 主要
  impala:  impala:
    database[0]:
      url: jdbc:impala://192.168.110.222:21050/default
      driver-class-name: com.cloudera.impala.jdbc41.Driver
      alias: impala1
      primary: true
    database[1]:
      url: jdbc:impala://192.168.110.223:21050/default
      driver-class-name: com.cloudera.impala.jdbc41.Driver
      alias: impala2
    database[2]:
      url: jdbc:impala://192.168.110.224:21050/default
      driver-class-name: com.cloudera.impala.jdbc41.Driver
      alias: impala3
  mybatis:
    hive:
      mapper-locations: classpath*:mappers/hive/**/*.xml
    impala:
      mapper-locations: classpath*:mappers/impala/**/*.xml
    database[0]:
      url: jdbc:impala://192.168.110.222:21050/default
      driver-class-name: com.cloudera.impala.jdbc41.Driver
      alias: impala1
      primary: true
    database[1]:
      url: jdbc:impala://192.168.110.223:21050/default
      driver-class-name: com.cloudera.impala.jdbc41.Driver
      alias: impala2
    database[2]:
      url: jdbc:impala://192.168.110.224:21050/default
      driver-class-name: com.cloudera.impala.jdbc41.Driver
      alias: impala3
  mybatis:
    hive:
      mapper-locations: classpath*:mappers/hive/**/*.xml
    impala:
      mapper-locations: classpath*:mappers/impala/**/*.xml
```

* hive 和 impala 数据操作路径注意
1. hive => com.rjgf.**.mapper.hive.**
2. impala => com.rjgf.**.mapper.impala.**

* 具体使用参考 RjgfHadoopApplicationTests 测试类


