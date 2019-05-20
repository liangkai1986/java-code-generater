注意事项：
该功能根据公司现有框架结构调整如下：
1：所有的表结构必须有如下属性
    字段名称               字段数据类型       备注信息
    UPDATE_TIMESTAMP     timestamp        创建时间
    CREATE_USER_ID       varchar          创建人ID
    UPDATE_TIMESTAMP     timestamp        修改时间
    UPDATE_USER_ID       varchar          修改人ID

2：为了适应后台的框架修改了Service层的代码结构，只有Service类，不生成ServiceImpl类；

3：生成的代码结构如下：
    com.smartwater.javacode.entity.xxx.java
    com.smartwater.javacode.controller.xxxController.java
    com.smartwater.javacode.service.xxxService.java
    com.smartwater.javacode.dao.xxxDao.java

    src/main/resources/xxxMapper.xml

更新：
1：根据数据库的备注字段生成实体对象的注释说明；
2：由于集成Mybatis-plus Mapper文件中的内容进行调整，
   dao接口不需要模板代码，只需要实现后续自己增加的代码；
3:集成接口说明文档swagger2方式实现；

