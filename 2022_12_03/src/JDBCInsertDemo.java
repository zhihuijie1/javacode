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






















