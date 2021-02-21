package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.导入驱动jar包(1.1复制jar包到libs目录下，右键--> Add as Library)
        //2.注册驱动
        //mysql5之后的驱动jar包可以省略下面语句
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象 ?加参数 多个参数可以用&连接,需要设置timezone
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo?serverTimezone=UTC", "root", "fengyunjia");
        //如果默认为localhost:3306则可以简写
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///todo?serverTimezone=UTC","root","fengyunjia");
        //定义sql语句
        String sql = "update record set title = 525 where id = 3";
        //5.获取执行sql的对象
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果, 返回值为影响的行数
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }

}
