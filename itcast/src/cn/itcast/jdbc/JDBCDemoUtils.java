package cn.itcast.jdbc;

//定义一个方法，查询users表的数据将其封装为对象，然后装载集合，返回

import cn.itcast.domain.Users;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemoUtils {
    public static void main(String[] args) {
        List<Users> list = new JDBCDemoUtils().findAll();
        System.out.println(list);
    }
    /**
     * 查询所有users对象
     *
     * @return
     */
    public List<Users> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Users> list = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from users";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //便利结果集，封装对象，装载集合
            Users user = null; //避免重复多个引用，节约资源
            list = new ArrayList<Users>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                //创建users对象
                user = new Users();
                user.setId(id);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                //装载集合
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }

        return list;
    }
}
