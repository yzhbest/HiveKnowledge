package com.yzhbest;

import java.sql.*;

/**
 * Created by yzh on 2019/4/29.
 */
public class JDBC2HiveTest {

    //注意 jar包的版本，与 hadoop,hive版本对应
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    private static String jdbcUrl="jdbc:hive2://192.168.2.9:10000/default;auth=noSasl";
    public static void main(String[] args) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            Connection con = DriverManager.getConnection(jdbcUrl);
            System.out.println(con.toString());
            System.out.println("con ok");
            Statement stmt = con.createStatement();
            System.out.println("stmt ok");
            String sql="select * from xp limit 10";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
