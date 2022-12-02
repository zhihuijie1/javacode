import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 查询article文章表中，发表日期create_date在2019年1月1日上午10点30分至2019年11月10日下午4点2分的文章
 */
public class JDBCInsertDemo {
    public static void main(String[] args) throws SQLException {
        // 创建数据源，指明数据库在哪里
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        // 连接数据库
        Connection connection = dataSource.getConnection();
        // 写sql语句
        String sql = "create table article(artic varchar(20),time datetime);";
        String sql2 ="insert into article (artic , time)values(\"新闻1\",'2022_11_12 10:12:12'),(\"新闻2\",'2019_11_12 10:12:12')," +
                "(\"新闻3\",'2019_01_12 10:12:12')";
        String sql3 = "select * from article where time between '2019-1-1-10:30:00' and '2019-11-10-16:02:00'";
        PreparedStatement statement = connection.prepareStatement(sql);
        int ret = statement.executeUpdate();
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        int ret2 = statement2.executeUpdate();
        PreparedStatement statement3 = connection.prepareStatement(sql3);
        ResultSet resultSet = statement3.executeQuery();
        System.out.println(ret2);
        System.out.println(ret);
        while(resultSet.next()) {
            System.out.println(resultSet.getString("artic") + " "+ resultSet.getInt("time"));
        }
        //断开连接
        statement.close();
        statement2.close();
        statement3.close();
        connection.close();
    }
}
