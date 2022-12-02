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

        int ret1 = statement1.executeUpdate();
        System.out.println(ret1);
        int ret2 = statement2.executeUpdate();
        System.out.println(ret2);

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(count < 4) {
            String name = scanner.next();
            String ID = scanner.next();
            int cishu = scanner.nextInt();
            statement3.setString(1,name);
            statement3.setString(2,ID);
            statement5.setInt(1,cishu);
            statement5.setString(2,ID);
            int ret3 = statement3.executeUpdate();
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
