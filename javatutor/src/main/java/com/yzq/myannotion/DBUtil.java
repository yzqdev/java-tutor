package com.yzq.myannotion;

import java.sql.*;
import java.util.Random;


@JDBCConfig(ip = "127.0.0.1", database = "qgzx", encoding = "UTF-8", loginName = "root", password = "123456")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getConnection() throws SQLException, SecurityException {
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);

        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        Connection conn = DriverManager.getConnection(url, loginName, password);
        // com.mysql.jdbc.JDBC4Connection@10d1f30
        // 3. 获得语句执行平台,通过数据库连接对象,获取到SQL语句的执行者对象
        //conn对象,调用方法 Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
        //返回的是Statement接口的实现类对象,在MySQL驱动程序中
        Statement stat = conn.createStatement();
        System.out.println(stat);//com.mysql.jdbc.StatementImpl@137bc9
        // 4. 执行sql语句
        //通过执行者对象调用方法执行SQL语句,获取结果
        //int executeUpdate(String sql)  执行数据库中的SQL语句,仅限于insert,update,delete
        //返回值int,操作成功数据库的行数
        Random random = new Random();

        int row = stat.executeUpdate("INSERT INTO notice (id,title,sub_title,content) VALUES( " + random.nextInt(300) + ",50000,'疯狂涨价','kakkkk')");
        ResultSet rs = stat.executeQuery("select * from notice");
        while (rs.next()) {
            // 获取每列的数据,使用的是ResultSet接口的方法getXXX
            int sid = rs.getInt("id");// 相当于rs.getInt(1);这个方法有弊端
            String sname = rs.getString("title");
            String sprice = rs.getString("sub_title");
            String sdesc = rs.getString("content");

            System.out.println(sid + "\t" + sname + "\t" + sprice + "\t" + sdesc);
        }
        rs.close();
        stat.close();
        conn.close();


    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        getConnection();


    }
}