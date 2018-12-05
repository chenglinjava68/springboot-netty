# springboot-netty
springboot2 管理netty. 实现通过 netty 接受 tcp 数据，并入库

## quick start

### 创建表

* 创建DB
* 执行 `./script/student.sql` 文件，创建 `student` 表

### 修改配置

修改 `.\src\main\resources\application.properties` 文件中关于 `JDBC` 部分的连接

### 启动程序

#### 启动主程序

直接运行 `com.dxp.springbootnetty.Application.java` 的 `mian` 函数，启动netty

#### 启动测试客户端

* 找到 `com.dxp.springbootnetty.test.MyClient.java`, 修改第 `24` 行的端口(如果刚才 `application.properties` 文件有修改 `netty.port` 则修改成对应值即可).
* 可启动多次，模拟多个 `客户端` 连接， 每个客户端在连接成功后会 发送 `10` 条学生记录进行存储

#### 查看数据库

连接数据库查看数据时候已经连接