package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 表添加记录
 */
public class JDBCDemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into record values(null,'jdbcdemo',null,'2021-02-12 21:28:21',null,0,2,null)";
            conn = DriverManager.getConnection("jdbc:mysql:///todo?serverTimezone=UTC", "root", "fengyunjia");
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0){
                System.out.println("添加成功");
            }
            else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {

        }finally {
            //避免空指针异常
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            //避免空指针异常
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
