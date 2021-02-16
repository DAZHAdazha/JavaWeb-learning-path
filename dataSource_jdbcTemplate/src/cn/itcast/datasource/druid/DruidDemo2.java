package cn.itcast.datasource.druid;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//使用工作类
public class DruidDemo2 {
    public static void main(String[] args) {
        //完成添加操作
        //1.获取连接
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into users values(null,?,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"DruidTest");
            pstmt.setString(2,"DruidTest@qq.com");
            pstmt.setString(3,"DruidTestPassword");
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(pstmt,conn);
        }

    }
}
