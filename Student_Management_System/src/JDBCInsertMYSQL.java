import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCInsertMYSQL {
    /**
     * 建立一个基本的学生框架
     */
    public static void create() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL1 = "create table student(ID int primary key auto_increment , name varchar(20) , status int , zhuanYe int , classes int ,)";
        // 做一下准备
        PreparedStatement statement = connection.prepareStatement(SQL1);
        int ret1 = statement.executeUpdate();
        System.out.println(ret1);
        statement.close();
        connection.close();
    }
    /**
     * 建立学生入学档案
     */
    public void admission(String name, int zhuanYe ,int classes) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL2 = "insert into student (name , zhuanYe , classes)values(? , ? , ?)";
        // 做一下准备
        PreparedStatement statement = connection.prepareStatement(SQL2);
        statement.setString(1,name);
        statement.setInt(2,zhuanYe);
        statement.setInt(3,classes);
        int ret2 = statement.executeUpdate();
        System.out.println(ret2);
        statement.close();
        connection.close();
    }

    /***
     * 课程表
     */
    public void courses_table() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL3 = "create table COURSE(ID int ,course_name varchar(20), score decimal(3,1))";
        String SQL4 = "insert into COURSE values(1 , '计算机组成原理')";
        String SQL5 = "insert into COURSE values(2 , '计算机网络')";
        String SQL6 = "insert into COURSE values(3 , '数据结构与算法')";
        String SQL7 = "insert into COURSE values(4 , '数据库原理')";
        String SQL8 = "select * from COURSE";
        // 做一下准备
        PreparedStatement statement3 = connection.prepareStatement(SQL3);
        PreparedStatement statement4 = connection.prepareStatement(SQL4);
        PreparedStatement statement5 = connection.prepareStatement(SQL5);
        PreparedStatement statement6 = connection.prepareStatement(SQL6);
        PreparedStatement statement7 = connection.prepareStatement(SQL7);
        PreparedStatement statement8 = connection.prepareStatement(SQL8);
        int ret3 = statement3.executeUpdate();
        int ret4 = statement4.executeUpdate();
        int ret5 = statement5.executeUpdate();
        int ret6 = statement6.executeUpdate();
        int ret7 = statement7.executeUpdate();
        ResultSet resultSet = statement8.executeQuery();
        while(resultSet.next()) {
            int ID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(" " + ID + " " + name);
        }
        // 断开数据库
        statement8.close();
        statement7.close();
        statement6.close();
        statement5.close();
        statement4.close();
        statement3.close();
        connection.close();
    }

    /**
     * 专业表
     */
    public void zhuanYe_table() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL3 = "create table zhuanYe(ID int ,zhuanYe_name varchar(20))";
        String SQL4 = "insert into zhuanYe values(1 , '信息工程')";
        String SQL5 = "insert into zhuanYe values(2 , '计算机工程')";
        String SQL6 = "insert into zhuanYe values(3 , '地理信息科学')";
        String SQL7 = "insert into zhuanYe values(4 , '数学')";
        String SQL8 = "select * from zhuanYe";
        // 做一下准备
        PreparedStatement statement3 = connection.prepareStatement(SQL3);
        PreparedStatement statement4 = connection.prepareStatement(SQL4);
        PreparedStatement statement5 = connection.prepareStatement(SQL5);
        PreparedStatement statement6 = connection.prepareStatement(SQL6);
        PreparedStatement statement7 = connection.prepareStatement(SQL7);
        PreparedStatement statement8 = connection.prepareStatement(SQL8);
        int ret3 = statement3.executeUpdate();
        int ret4 = statement4.executeUpdate();
        int ret5 = statement5.executeUpdate();
        int ret6 = statement6.executeUpdate();
        int ret7 = statement7.executeUpdate();
        ResultSet resultSet = statement8.executeQuery();
        while(resultSet.next()) {
            int ID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(" " + ID + " " + name);
        }
        // 断开数据库
        statement8.close();
        statement7.close();
        statement6.close();
        statement5.close();
        statement4.close();
        statement3.close();
        connection.close();
    }

    /**
     * 班级表
     */
    public void classes_table() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL3 = "create table classes(ID int ,classes_name varchar(20), zhuanYe_ID int )";
        String SQL4 = "insert into classes values(1 , '信息一班', 1)";
        String SQL5 = "insert into classes values(2 , '信息二班', 1)";
        String SQL6 = "insert into classes values(1 , '计算一班', 2)";
        String SQL7 = "insert into classes values(2 , '计算二班', 2)";
        String SQL8 = "insert into classes values(1 , '地科一班', 3)";
        String SQL9 = "insert into classes values(2 , '地科二班', 3)";
        String SQL10 = "insert into classes values(1 ,'数学一班', 4)";
        String SQL11 = "insert into classes values(2 ,'数学二班', 4)";
        String SQL12 = "select zhuanYe.ID , zhuanYe.zhuanYe_name ,  classes.ID, classes.classes_name from classes, zhuanYe " +
                "where classes.zhuanYe_ID = zhuanYe.ID group by  classes.classes_name";
        // 做一下准备
        PreparedStatement statement3 = connection.prepareStatement(SQL3);
        PreparedStatement statement4 = connection.prepareStatement(SQL4);
        PreparedStatement statement5 = connection.prepareStatement(SQL5);
        PreparedStatement statement6 = connection.prepareStatement(SQL6);
        PreparedStatement statement7 = connection.prepareStatement(SQL7);
        PreparedStatement statement8 = connection.prepareStatement(SQL8);
        PreparedStatement statement9 = connection.prepareStatement(SQL9);
        PreparedStatement statement10 = connection.prepareStatement(SQL10);
        PreparedStatement statement11 = connection.prepareStatement(SQL11);
        PreparedStatement statement12 = connection.prepareStatement(SQL12);
        int ret3 = statement3.executeUpdate();
        int ret4 = statement4.executeUpdate();
        int ret5 = statement5.executeUpdate();
        int ret6 = statement6.executeUpdate();
        int ret7 = statement7.executeUpdate();
        int ret8 = statement8.executeUpdate();
        int ret9 = statement9.executeUpdate();
        int ret10 = statement10.executeUpdate();
        int ret11 = statement11.executeUpdate();
        ResultSet resultSet = statement12.executeQuery();
        while(resultSet.next()) {
            int ID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(" " + ID + " " + name);
        }
        // 断开数据库
        statement12.close();
        statement11.close();
        statement10.close();
        statement9.close();
        statement8.close();
        statement7.close();
        statement6.close();
        statement5.close();
        statement4.close();
        statement3.close();
        connection.close();
    }

    /**
     *  studentID_course_ID表
     */
    public void studentID_course_ID() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL3 = "create table studentID_course_ID(student_ID int , course_ID int)";
        // 做一下准备
        PreparedStatement statement3 = connection.prepareStatement(SQL3);
        int ret3 = statement3.executeUpdate();
        // 断开数据库
        statement3.close();
        connection.close();
    }

    /**
     * 查看学生表
     */
    public  void getStudent() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL1 = "select *  from student";
        // 做一下准备
        PreparedStatement statement = connection.prepareStatement(SQL1);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            int studentID = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            int status = resultSet.getInt(3);
            int zhuanYe = resultSet.getInt(4);
            int classes = resultSet.getInt(5);
            String course = resultSet.getString(6);
            BigDecimal score = resultSet.getBigDecimal(7);
            System.out.println("studentID: "+ studentID+ " " + "studentName: " + studentName + " " +"status: "+ status + " " +
                    "zhuanYe: " + zhuanYe + " " +"classes: "+ classes + " ");
        }
        statement.close();
        connection.close();
    }

    /**
     * 获取专业表
     */

    public void getZhuanYe() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL8 = "select * from zhuanYe";
        // 做一下准备
        PreparedStatement statement8 = connection.prepareStatement(SQL8);
        ResultSet resultSet = statement8.executeQuery();
        while(resultSet.next()) {
            int ID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(" " + ID + " " + name);
        }
        // 断开数据库
        statement8.close();
        connection.close();
    }

    /**
     * 获取课程表
     */
    public void getCourse() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL8 = "select * from COURSE";
        // 做一下准备
        PreparedStatement statement8 = connection.prepareStatement(SQL8);
        ResultSet resultSet = statement8.executeQuery();
        while(resultSet.next()) {
            int ID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            BigDecimal bigDecimal = resultSet.getBigDecimal(3);
            System.out.println(" " + ID + " " + name + " " + bigDecimal);
        }
        // 断开数据库
        statement8.close();
        connection.close();
    }

    public void Insert_studentID_course_ID(int student_ID , int course_ID) throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL4 = "insert into studentID_course_ID values(? , ?)";
        // 做一下准备
        PreparedStatement statement4 = connection.prepareStatement(SQL4);
        statement4.setInt(1,student_ID);
        statement4.setInt(2,course_ID);
        int ret4 = statement4.executeUpdate();
        System.out.println( " " + ret4 + " "+ "ok");
        // 断开数据库
        statement4.close();
        connection.close();
    }

    /**
     * 获取课程表
     */
    public void get_studentID_course_ID() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL4 = "select * from studentID_course_ID";
        // 做一下准备
        PreparedStatement statement4 = connection.prepareStatement(SQL4);
        ResultSet resultSet = statement4.executeQuery();
        while (resultSet.next()) {
            int studentID = resultSet.getInt(1);
            int courseID = resultSet.getInt(2);
            System.out.println(studentID + " " + courseID);
        }
        // 断开数据库
        statement4.close();
        connection.close();
    }

    /**
     * 获取班级表
     * @throws SQLException
     */
    public void get_classes_table() throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句

        String SQL12 = "select zhuanYe.ID , zhuanYe.zhuanYe_name ,  classes.ID, classes.classes_name from classes, zhuanYe " +
                "where classes.zhuanYe_ID = zhuanYe.ID group by classes.classes_name";
        // 做一下准备
        PreparedStatement statement12 = connection.prepareStatement(SQL12);
        ResultSet resultSet = statement12.executeQuery();
        while(resultSet.next()) {
            int zhuanYeID = resultSet.getInt(1);
            String zhuanYeName = resultSet.getString(2);
            int classID = resultSet.getInt(3);
            String className = resultSet.getString(4);
            System.out.println(" " + zhuanYeID + " " + zhuanYeName + " " + classID + " " + className);
        }
        // 断开数据库
        statement12.close();
        connection.close();
    }

    /**
     * 修改学籍
     */
    public void setStatus(int studentID , int status) throws SQLException {
        // 知名数据库的位置
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        // 写SQL语句
        String SQL4 = "update student set status = ? where student.ID = ?";
        // 做一下准备
        PreparedStatement statement4 = connection.prepareStatement(SQL4);
        statement4.setInt(1,status);
        statement4.setInt(2,studentID);
        int ret4 = statement4.executeUpdate();
        System.out.println(ret4);
        // 断开数据库
        statement4.close();
        connection.close();
    }

    /**
     * 得到一个完全表
     */
    public void getFullTable() throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_menerge?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 建立了连接
        Connection connection = dataSource.getConnection();
        String SQL = "select stduent.ID , student.name , stduent.status , student.zhuanYe , student.classes , " +
                "COURSE.course_name, COURSE.score from student,COURSE,studentID_course_ID " +
                "where student.ID = studentID_course_ID.student_ID and studentID_course_ID.course_ID = COURSE.ID";
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            int studentID = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            int studentStatus = resultSet.getInt(3);
            int
        }
}