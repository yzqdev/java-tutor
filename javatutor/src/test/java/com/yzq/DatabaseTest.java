package com.yzq;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author yanni
 * @date time 2021/10/14 11:51
 * @modified By:
 */
public class DatabaseTest {
    @Test
    void connectMysql() {
        String url = "jdbc:mysql://localhost:3306/how2j?charactorEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String pass = "123456";
        Connection c = null;
        String sql=null;
        Statement s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, user, pass);
            s = c.createStatement();
            // 准备sql语句
            // 注意： 字符串要用单引号'
            ArrayList<String> herolist = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                //herolist.add("heros" + i);

                sql = "insert into hero values(null,"+i + "," + 313.0f + "," + 50 + ")";System.out.println(sql);
                s.execute(sql); }



            System.out.println("执行插入语句成功");
            System.out.println(s);
            System.out.println(c);
            System.out.println("success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
