# RESTful API 综合练习

## 练习描述
- 在已有的 [Sping Data JPA](https://github.com/tws-online-quiz/Spring-Data-JPA-Quiz) 项目基础上，使用JPA的`@OneToMany`注解实现Company和Employee是**一对多**的关系，实现级联删除，查询
- 要求使用Flyway命令对数据进行迁移
- 要求实现下述RESTful API
#### Company API
```
GET       /companies    #获取company列表
GET       /companies/1  #获取某个具体company
GET       /companies/1/employees  #获取某个具体company下所有employee列表
GET       /companies/page/1/pageSize/5  #分页查询，page等于1，pageSize等于5
POST      /companies    #增加一个company
PUT       /companies/1  #更新某个company
DELETE    /companies/1  #删除某个company以及名下所有employees
```

#### employees API
```
GET       /employees    #获取employee列表
GET       /employees/1  #获取某个具体employee
GET       /employees/page/1/pageSize/5  #分页查询，page等于1，pageSize等于5
GET       /employees/male   #筛选出所有男性Employee
POST      /employees    #增加一个employee
PUT       /employees/1  #更新某个employee
DELETE    /employees/1  #删除某个employee
```
- 要求使用postman测试接口，并将结果截图(如下)放入自己创建`result`文件中
![](https://raw.githubusercontent.com/tws-online-quiz/restful-api/master/example.png)


## 环境要求
- java8
- Intellij-IDEA
- MySQL

## 如何开始
- 本地克隆模版代码库
- 本地启动 MySQL Service,确保本地存在employee_db数据库
- 并将数据库的 url username password 配置到项目中
- 使用`./gradlew flywayMigrate`命令进行将数据迁移至employee_db数据库中
- 使用JPA注解实现Company和Employee的**一对多**关系
- 在`controller`中实现上述所有RESTful API接口

## 输出规范
- RESTful API的实现
- 包含API测试结果截图的result文件夹
