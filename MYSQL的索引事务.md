[TOC]

# 1：索引



### 1.1：概念：



索引是一种特殊的文件，包含着对数据表里所有记录的引用指针。可以对表中的一列或多列创建索引，
并指定索引的类型，各类索引有各自的数据结构实现。



### 1.2 作用：



数据库中的表、数据、索引之间的关系，类似于书架上的图书、书籍内容和书籍目录的关系。索引所起的作用类似书籍目录，可用于快速定位、检索数据。索引对于提高数据库的性能有很大的帮助，索引保存了排序的字段以及数据的地址



### 1.3 使用场景：

要考虑对数据库表的某列或某几列创建索引，需要考虑以下几点：

- 数据量较大，且**经常对这些列进行条件查询**。
- 该数据库表的**插入操作，及对这些列的修改操作频率较低**。
- 索引会占用额外的**磁盘空间**。

满足以上条件时，考虑对表中的这些字段创建索引，以提高查询效率。
反之，如果非条件查询列，或经常做插入、修改操作，或磁盘空间不足时，不考虑创建索引



### 1.4 使用：

创建**主键约束（PRIMARY KEY）**、**唯一约束（UNIQUE）**、**外键约束（FOREIGN KEY）**时，会**自动创建**
对应列的索引。



- **查看索引**

  ```mysql
  show index from 表名
  ```

  ![](D:/%E4%BD%A0%E5%A5%BDJava/850.png)

- **创建索引**

  对于非primary key，非 foreign key ，非unique类型的字段，可以创建普通的索引。

  ```mysql
  create index 索引名 on 表名(字段名);
  -- 例如:
  create index IND on score(student_id);
  ```

- **删除索引**

  ```mysql
  drop index 索引名 on 表名
  -- 例如:
  drop index IND on score;
  ```

  

# 2：事务



### 2.1：为什么使用事务

**（保证以多条SQL要么全部执行成功，要么全部执行失败）**



你在转账的时候，A给B转账100元，A账户的金额应该减少100，B账户的金额应该增加100，

```mysql
-- A账户减少100
update accout set money=money-100 where name = 'A';
-- B账户增加100
update accout set money=money+100 where name = 'B';
```

假如在执行以上第一句SQL时，出现网络错误，或是数据库挂掉了，A的账户会减少100，但是
B的账户上就没有了增加的金额。
解决方案：使用事务来控制，**保证以上两句SQL要么全部执行成功，要么全部执行失败。**



### 2.2：事务的概念

事务指逻辑上的**一组操作**，组成这组操作的**各个单元，要么全部成功，要么全部失败**。
在不同的环境中，都可以有事务。对应在数据库中，就是数据库事务。



# 3：Java的JDBC编程



### 3.1：数据库编程的必备条件



- **编程语言**，如Java，C、C++、Python等

- **数据库**，如Oracle，MySQL，SQL Server等

- **数据库驱动包**：不同的数据库，对应不同的编程语言提供了不同的数据库驱动包，如：MySQL提

  供了Java的驱动包mysql-connector-java，需要基于Java操作MySQL即需要该驱动包。同样的，

  要基于Java操作Oracle数据库则需要Oracle的数据库驱动包ojdbc



###  3.2：Java的数据库编程：JDBC



JDBC，即Java Database Connectivity，java数据库连接。是一种用于执行SQL语句的Java API，它是
Java中的数据库连接规范。这个API由 java.sql.*,javax.sql.* 包中的一些类和接口组成，它为Java
开发人员操作数据库提供了一个标准的API，可以为多种关系数据库提供统一访问



### 3.3：JDBC工作原理



JDBC 为多种关系数据库提供了统一访问方式，作为特定厂商数据库访问API的一种高级抽象，它主要包
含一些通用的接口类。
JDBC访问数据库层次结构:

![](D:/%E4%BD%A0%E5%A5%BDJava/851.png)



**JDBC优势：**

Java语言访问数据库操作完全面向抽象接口编程
开发数据库应用不用限定在特定数据库厂商的API
程序的可移植性大大增强



### 3.4：JDBC使用

刚上来的操作是：准备数据库驱动包，并添加到项目的依赖中



```java
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertDemo {
    public static void main(String[] args) throws SQLException {
        /*
        * 先去创建数据源，描述一下数据库在哪里*/
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&&useSSL=false");
        //注意你数据库的指明在这里
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        /*
        * 连接数据库*/
        Connection connection = dataSource.getConnection();
        /*
        * 写sql语句*/
        String sql1 = "create table person(name varchar(20), ID varchar(20))";
        /*
        * 准备一下*/
        PreparedStatement statement = connection.prepareStatement(sql1);
        int ret = statement.executeUpdate();
        System.out.println(ret);
        /*
        * 断开连接*/
        statement.close();
        connection.close();
    }
}
```



JDBC的使用案例：



```java
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemo3 {
    /**
     * 考勤系统，包含员工表，考勤记录表
     */
    public static void main(String[] args) throws SQLException {
        // 创建数据源，指明数据库在哪里
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立连接
        Connection connection = dataSource.getConnection();
        // 写sql语句
        String sql1 = "create table person(name varchar(20), ID varchar(20))";
        String sql2 = "create table kaoqin(cishu int,ID varchar(20))";
        String sql3 = "insert into person values(?,?)";
        String sql4 = "select * from person,kaoqin where person.ID = kaoqin.ID";
        String sql5 = "insert into kaoqin values(?,?)";
        // 做一下准备
        PreparedStatement statement1 = connection.prepareStatement(sql1);
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        PreparedStatement statement3 = connection.prepareStatement(sql3);
        PreparedStatement statement4 = connection.prepareStatement(sql4);
        PreparedStatement statement5 = connection.prepareStatement(sql5);
        //注意执行顺序：先把两个表给创建出来
        int ret1 = statement1.executeUpdate();
        System.out.println(ret1);
        int ret2 = statement2.executeUpdate();
        System.out.println(ret2);
        // 开始往表里输入数据
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(count < 4) {
            String name = scanner.next();
            String ID = scanner.next();
            int cishu = scanner.nextInt();
            statement3.setString(1,name); // 指明字段的列号，已经输入的变量名
            statement3.setString(2,ID);
            statement5.setInt(1,cishu);
            statement5.setString(2,ID);
            int ret3 = statement3.executeUpdate(); //每次输入完都要executeUpdate
            System.out.println(ret3);
            int ret5 = statement5.executeUpdate();
            count++;
        }

        ResultSet resultSet = statement4.executeQuery();
        while(resultSet.next()) {
            String nam = resultSet.getString("name");
            int cishu = resultSet.getInt("cishu");
            String ID = resultSet.getString("ID");
            System.out.println(nam+" "+ ID +" "+ cishu);
        }

        // 断开连接
        statement5.close();
        statement4.close();
        statement3.close();
        statement2.close();
        statement1.close();
        connection.close();
    }
}
```



注意：

- 增，删，改的 写完数据以后要   statement.executeUpdate()  返回值的类型是int类型，意思是影响了几行的数据
- 查：写完数据以后要     statement . executeQuery()  返回值的类型是 ResultSet ，是一个集合，可以写一个循环来一条一条的输出里面的数据。
- ResultSet对象
  ResultSet对象它被称为结果集，它代表符合SQL语句条件的所有行，并且它通过一套getXXX方法提供
  了对这些行中数据的访问。
  ResultSet里的数据一行一行排列，每行有多个字段，并且有一个记录指针，指针所指的数据行叫做当
  前数据行，我们只能来操作当前的数据行。我们如果想要取得某一条记录，就要使用ResultSet的next()
  方法 ,如果我们想要得到ResultSet里的所有记录，就应该使用while循环。























