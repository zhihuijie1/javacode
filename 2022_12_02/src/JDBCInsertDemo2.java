import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemo2 {
    /**
     * 删除商品表中，价格大于60，或者是库存小于200的记录
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
        String sql1 = "create table shop(name varchar(20), price decimal(4,2), capticy int )";
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        BigDecimal price = scanner.nextBigDecimal();
        int capticy = scanner.nextInt();
        String sql3 = "insert into shop values(?,?,?)";
        String sql2 = "delete from shop where price > 60 or capticy < 200";
        String sql4 = "select * from shop";
        // 做一下准备
        PreparedStatement statement1 = connection.prepareStatement(sql1);
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        PreparedStatement statement3 = connection.prepareStatement(sql3);
        PreparedStatement statement4 = connection.prepareStatement(sql4);
        statement3.setString(1,name);
        statement3.setBigDecimal(2,price);
        statement3.setInt(3,capticy);
        int ret1 = statement1.executeUpdate();
        System.out.println(ret1);
        int ret3 = statement3.executeUpdate();
        System.out.println(ret3);
        int ret2 = statement2.executeUpdate();
        System.out.println(ret2);
        ResultSet resultSet = statement4.executeQuery();
        while(resultSet.next()) {
            String nam = resultSet.getString("name");
            BigDecimal bigDecimal = resultSet.getBigDecimal("price");
            int capticys = resultSet.getInt("capticy");
            System.out.println(nam+" "+ bigDecimal +" "+ capticys);
        }
        // 断开连接
        statement2.close();
        statement1.close();
        connection.close();
    }
}



