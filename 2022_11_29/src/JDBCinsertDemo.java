import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCinsertDemo {
    public static void main(String[] args) throws SQLException {
        //1:先去创建数据源，描述一下数据库在哪里
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        //2:和数据库进行连接
        Connection connection = dataSource.getConnection();
        //:构造一个sql语句
        String sql = "insert into student values(8," + "34345", + ,'3434',2)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}










