[toc]

# SpringBoot入门操作笔记[+mybatis&mysql]

> @Author: hanhan
> hanhan的设备：Mac M1
> hanhan的开发工具：IDEA
>
> ==本文就做了短短一篇，内容仅针对于新创建项目的入门级操作，有SSM的基础会阅读更加轻松==

## 1. 创建工程

### 1.1. 新建SpringBoot项目

先在IDEA中新建一个项目，配置可以如下图所示：

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0pggucdmcj20ma0itq45.jpg" style="zoom:50%;" />

解释一下配置：

- Group：公司域名
- Artifact：项目名称
- SDK：选择自己用的jdk
- Packaging：me采用Jar工程方式

选择下一步之后会有个选择依赖的界面，这里本人在项目里面手配pom，不选直接完成。

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0pgsxosg1j20ma0it3zj.jpg" style="zoom:50%;" />

看一看配置完之后的界面：

![](https://tva1.sinaimg.cn/large/e6c9d24egy1h0ph2tnof9j21hc0tb77z.jpg)

### 1.2. 配置Maven

打开Preferences，在Windows里面是打开Settings，可以添加Maven的设置：

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0ph6ay5joj20qv0k8tah.jpg" style="zoom:50%;" />

按照图片里面的位置配置好，Maven的路径选择自己安装的就好了。

### 1.3. 编码配置

还是在Preferences里面配置，全部配置成utf8（一共三个）：

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0phxff88mj20qv0k8wgg.jpg" alt="image-20220328124403519" style="zoom:50%;" />

## 2. 项目结构

SpringBoot有三个主要模块：

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0pi4uozmwj20ay0damxt.jpg" alt="image-20220328125111700" style="zoom: 67%;" />

- src/main/java：编写业务程序
- src/main/resources：存放静态文件和配置文件
- src/test/java：编写测试程序

这个列表里面有些创建之后没有的东西就自己加上去就好了。

其中在src的java文件夹下有个自动创建的Application类，在这个类的上面会有一个`@SpringBootApplication`的注释，这个类是SpringBoot的启动类。含义就是启动这个main函数就可以运行项目了，不用担心Tomcat的问题，因为SpringBoot里面集成了Tomcat。

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0picpjmfej20ye0mxgog.jpg" alt="image-20220328125844400" style="zoom:67%;" />

## 3. 配置环境

打开SpringBoot的配置文件pom.xml，在里面添加依赖就可以配置Maven了。

SpringBoot主要就两个依赖要配置，可以看这：

```xml
<!-- 测试 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
<!-- SpringMVC -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

然后因为我还要用到MySQL和MyBatis，下面放上我的全配置文件：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--父级项目-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.5</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <!-- 项目信息 -->
    <groupId>hanhan</groupId> <!-- 项目唯一标识 -->
    <artifactId>demo</artifactId> <!-- 项目名 -->
    <version>0.0.1-SNAPSHOT</version> <!-- 版本 -->
    <packaging>jar</packaging> <!-- 打包方式 -->
    <name>SpringBootDemo</name> <!-- 项目的名称 -->
    <description>Demo project for Spring Boot</description> <!-- 项目的描述 -->

    <!-- 属性设置 -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> <!-- 编译字符编码为utf-8 -->
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding> <!-- 输出字符编码为UTF-8  -->
        <java.version>1.8</java.version> <!-- JDK版本 -->
    </properties>

    <!-- 依赖关系 -->
    <dependencies>
        <!-- 测试 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- SpringMVC -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- MyBatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.2</version>
        </dependency>
        <!-- MySQL -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>

    <!-- 编译 -->
    <build>
        <!-- 插件 -->
        <plugins>
            <!-- Maven插件 -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <skip>true</skip>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

然后是配置文件：我将application.properties改成了application.yml，都是配置文件，不过yml的逻辑结构清晰好看一些，所以改用yml。

其中上面说到的yml配置文件，里面就可以配置一些参数，比如可以将SpringBoot运行的端口好写进去，我比较喜欢3000，所以这里我改成3000（然后再加上我的mysql和mybatis的配置）：

```yml
server:
  port: 3000 # Tomcat端口号

spring: # springboot配置
  datasource: # 定义数据源
    name: hanhan
    url: jdbc:mysql://localhost:3306/demo?characterEncoding=utf8
    username: root
    password: password

mybatis:
  mapper-locations: classpath:mapper/*.xml # 通配mapper文件
  type-aliases-package: hanhan.demo.Entity # 给所有的对象类取别名，简化在xml中写全名如hanhan.demo.Entity.User=User
  configuration:
    map-underscore-to-camel-case: true # 开启驼峰命名法与下划线的自动匹配机制
```

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0pj2wg0tlj208a02swed.jpg" alt="image-20220328132354633"  />

## 4. Controller层编写

### 4.1 简单的测试

创建一个UserController，写一个简单的测试代码：

```java
package hanhan.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/start")
    public String StartSpringBoot() {
        return "Start SpringBoot Success!";
    }
}
```

然后看一下运行成果：

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0pj8cq27tj21420hgwf0.jpg" alt="image-20220328132909056" style="zoom:50%;" />

运行成功没问题。

### 4.2. Json的读写

我们经常会用Json格式的数据在前后端进行交换与传输。所以这里讲一下怎么向前端发送Json数据与接受前端的Json数据。

一样还是在Controller中写几个函数用来做测试：

```java
package hanhan.demo.Controller;

import hanhan.demo.Dao.Impl.UserDaoImpl;
import hanhan.demo.Dao.UserDao;
import hanhan.demo.Entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/start")
    public String StartSpringBoot() {
        return "Start SpringBoot Success!";
    }

    @RequestMapping("/getjson1")
    public List<User> GetJson1() {
        UserDao dao = new UserDaoImpl();
        return dao.FindAll();
    }

    @RequestMapping("/getjson2")
    public Map<String, Object> GetJson2() {
        UserDao dao = new UserDaoImpl();
        Map<String, Object> mp = new HashMap<>();
        List<User> ls = dao.FindAll();
        mp.put("data", ls);
        mp.put("cnt", ls.size());
        return mp;
    }

    @RequestMapping("/userlist.do")
    public Map<String, Object> GetUserlist(@RequestBody Map<String, Object> mp) {
        return mp;
    }
}
```

这样我们就有了三个函数，getjson1用于返回列表类的json数据，getjson2用于返回map类的json数据，getjson接收前端数据并返回。测试结果当然是成功的，这里唯一要讲的是为什么不像MVC一样在每个函数上面加一个`@ResponseBody`，因为在类上面我们加上的注释是`@RestController`而不是`Controller`，学过SSM的同志应该都知道这是给Controller层注解用的，而`@RestController`的意思是`@ResponseBody`+`@Controller`。所以可以省略掉了。

这里附带一下前端发送数据的代码：

```html
<!--userlist.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>userlist</title>
    <script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/js/user/userlist.js"></script>
</head>
<body>
<h1>data:</h1>
<div id="userlist"></div>
</body>
</html>
```

```js
// userlist.js
$.ajax({
    url: '/userlist.do',
    type: 'POST',
    dataType: "json",
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify({
        "data": [
            {
                "username": "hanhan1",
                "password": "pwd"
            },
            {
                "username": "hanhan2",
                "password": "pwd"
            },
            {
                "username": "hanhan3",
                "password": "pwd"
            },
            {
                "username": "hanhan4",
                "password": "pwd"
            },
            {
                "username": "hanhan5",
                "password": "pwd"
            },
            {
                "username": "hanhan6",
                "password": "pwd"
            }
        ],
        "cnt": 6
    }),
    success: function (jdata) {
        console.log(jdata);
        var html = '';
        jdata.data.map(function (item, index) {
            html += '<' + index + '>:' + item.username + ',' + item.password + '<br>'
        });
        $("#userlist").html(html);
    }
})
```

## 5. Dao层&Mapper的编写

创建Dao层的文件夹，编写UserMapper接口类，类内容如下（在这里我写了注解方式，要用的话直接把UserMapper.xml删掉就好了）。这里唯一要注意的地方是包含两个注解，一个`@Mapper`是用来表示这是Mapper层文件的，还有一个`@Repository`就是Dao层的自动装配注解，用于注入对象，本文将其注入到Service层中调用：

```java
package hanhan.demo.Dao;

import hanhan.demo.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
//    @Insert("INSERT user(u_username, u_password) VALUES (#{uUsername}, #{uPassword})")
    int AddUser(User usr);

//    @Delete("DELETE FROM user WHERE u_id=#{id}")
    int DeleteUserById(@Param("id") int id);

//    @Update("UPDATE user SET u_password=#{pwd} WHERE u_username=#{uname}")
    int UpdatePwdByUname(@Param("uname") String username, @Param("pwd") String password);

//    @Select("SELECT * FROM user")
    List<User> FindAll();

//    @Select("SELECT * FROM user WHERE u_username like '%${uname}%'")
    List<User> FindByUname(@Param("uname") String username);
}
```

然后在resource中配置一个mapper文件夹，里面包含UserMapper.xml文件。这里的一个关键点是我的resultType是直接用了User的，因为我前面写了一个取别名的配置如下。还有一个值得一提的是：

```yml
mybatis:
  mapper-locations: classpath:mapper/*.xml # 通配mapper文件
  type-aliases-package: hanhan.demo.Entity # 给所有的对象类取别名，简化在xml中写全名如hanhan.demo.Entity.User=User
  configuration:
    map-underscore-to-camel-case: true # 开启驼峰命名法与下划线的自动匹配机制
```

然后展示一下整个UserMapper.xml文件，parameterType很多情况是可以不写的，在输入为一个类的时候也可以不写，会自动识别的：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="hanhan.demo.Dao.UserMapper">
    <insert id="AddUser">
        INSERT user(u_username, u_password) VALUES (#{uUsername}, #{uPassword})
    </insert>

    <delete id="DeleteUserById">
        DELETE FROM user WHERE u_id=#{id}
    </delete>

    <update id="UpdatePwdByUname">
        UPDATE user SET u_password=#{pwd} WHERE u_username=#{uname}
    </update>

    <select id="FindAll" resultType="User">
        SELECT * FROM user
    </select>

    <select id="FindByUname" resultType="User">
        SELECT * FROM user WHERE u_username like '%${uname}%'
    </select>
</mapper>
```

整体构建框架是这样子的：

<img src="https://tva1.sinaimg.cn/large/e6c9d24ely1h0q385rx7rj20de0fkq3q.jpg" style="zoom:50%;" />

## 6. Service层的编写

Service层其实也很好编写，基本是直接调用，写一个接口函数，再写一个实现类就好了：

先看接口：

```java
package hanhan.demo.Service;

import hanhan.demo.Entity.User;

import java.util.List;

public interface UserService {
    int AddUser(User usr);

    int DeleteUserById(int id);

    int UpdatePwdByUname(String username, String password);

    List<User> FindAll();

    List<User> FindByUname(String username);
}
```

然后是实现类，唯一可以讲的就是注入了UserMapper和自动装配了UserService：

```java
package hanhan.demo.Service.Impl;

import hanhan.demo.Dao.UserMapper;
import hanhan.demo.Entity.User;
import hanhan.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public int AddUser(User usr) {
        return mapper.AddUser(usr);
    }

    @Override
    public int DeleteUserById(int id) {
        return mapper.DeleteUserById(id);
    }

    @Override
    public int UpdatePwdByUname(String username, String password) {
        return mapper.UpdatePwdByUname(username, password);
    }

    @Override
    public List<User> FindAll() {
        return mapper.FindAll();
    }

    @Override
    public List<User> FindByUname(String username) {
        return mapper.FindByUname(username);
    }
}
```

## 7. 测试代码

测试代码的时候有几个要注意的点：

- 添加注释：SpringBoot进行测试需要运行项目，所以要加一个`@SpringBootTest`的注解，然后函数上面加`@test`是毋庸置疑的。

- pom配置：单纯加入了测试还不够，有可能会报要“跳过”的错，可以在pom中添加一个可以让bug正常化的代码：添加一个配置

	```xml
	<plugin>
	  <groupId>org.apache.maven.plugins</groupId>
	  <artifactId>maven-surefire-plugin</artifactId>
	  <configuration>
	    <skip>true</skip>
	  </configuration>
	</plugin>
	```

	然后就可以正常测试了。

这里我写了一段测试代码表示确实可以运行了：

<img src="https://tva1.sinaimg.cn/large/e6c9d24egy1h0qgo6h6s9j21400obgpt.jpg" alt="image-20220329084608002" style="zoom:50%;" />