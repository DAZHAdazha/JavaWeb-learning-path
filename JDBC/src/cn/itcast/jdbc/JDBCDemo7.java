package cn.itcast.jdbc;

import java.sql.*;

//执行DDL
public class JDBCDemo7 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///todo?serverTimezone=UTC","root","fengyunjia");
            String sql = "select * from record";
            stmt =  conn.createStatement();
            rs = stmt.executeQuery(sql);
            //让游标向下移动一行
            //判断表是否有数据
            while(rs.next()){
                //获取数据
                int id = rs.getInt(1);
                String title = rs.getString("title");
                Time time =  rs.getTime("date");
                System.out.println(id +" "+ title + " " + time);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //记得释放rs资源！！！
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
