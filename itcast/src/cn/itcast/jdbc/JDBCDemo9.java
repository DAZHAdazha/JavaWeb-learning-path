package cn.itcast.jdbc;

//使用preparedStatement更安全的方法，预防sql注入

import cn.itcast.domain.Users;
import cn.itcast.util.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBCDemo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id");
        int new_id = sc.nextInt();
        List<Users> list = new JDBCDemo9().findAll(new_id);
        System.out.println(list);
    }
    /**
     * 查询所有users对象
     *
     * @return
     */
    public List<Users> findAll(int new_id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Users> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //使用preparedStatement需要使用问号来作为占位符
            String sql = "select * from users where id = ?";
            pstmt = conn.prepareStatement(sql);
            //给问号赋值,第一个参数为问号序号，第二个为所赋的值
            pstmt.setInt(1,new_id);
            rs = pstmt.executeQuery();
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
            JDBCUtils.close(rs,pstmt,conn);
        }

        return list;
    }
}
