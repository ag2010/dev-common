# springboot+tkmybatis-demo

#### Description
springboot+tkmybatis的示例项目，开箱即用。

# _*平台简介*_
## 所用技术栈
1. springboot 2.5.6
2. hutool 5.7.12
3. fastjson 1.2.78
4. lombok
5. tk.mybatis
6. mybatis.generator
7. PageHelper分页插件 1.2.5
8. Knife4j 2.0.2（swagger的升级版，界面更友好。）

#使用步骤
1. 找到resources文件夹下的ry-vue.sql，进行sql新建。
2. 配置代码生成xml。
3. <classPathEntry>标签内容的地址修改为你本地jar所在位置
4. generator.properties文件里配置数据库连接。#table则是你需要生存实体的表名。可多张表生成数据。
5. 此时启动GeneratorUtil类的main方法则可以生成实体以及mapper和xml文件。（项目本身已经有student和student_content表不需要再生成相同的）
6. 在applicaton.yml配置对应的端口号，数据库连接则可以启动。
7. 启动完项目 浏览器输入 http://localhost:8080/doc.html#/home 。则能看见对应数据接口。

