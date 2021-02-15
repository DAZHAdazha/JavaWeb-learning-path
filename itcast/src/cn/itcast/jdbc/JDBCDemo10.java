package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//事务
public class JDBCDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //定义sql： record中id ? 和 ?的 记录tag都改为"?"
            String sql1 = "update record set tag = ? where id = ?";
            String sql2 = "update record set tag = ? where id = ?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setString(1,"JDBC");
            pstmt1.setInt(2,10);
            pstmt2.setString(1,"JDBC");
            pstmt2.setInt(2,11);
            pstmt1.executeUpdate();

            //手动制造异常
//            int i = 3/0;

            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
            //抓大的异常
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn != null){
                    conn.rollback();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }
    }
}
