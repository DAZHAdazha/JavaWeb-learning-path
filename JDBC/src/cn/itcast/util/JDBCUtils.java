package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

//JDBC工具类
public class JDBCUtils {
    /**
     * 文件读取配置文件来加载connection，只需要读取一次即可拿到这些值。使用静态代码块（只会在类生成时候运行一次）
     */
    //只有static变量才能被静态代码块使用
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static{
        //读取资源文件，获取值
        //1.创建Properties集合类
        Properties pro = new Properties();
        //2.加载文件
        try {
            //获取src路径下的文件的方式-->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            //也可以写绝对路径
            pro.load(new FileReader(path));
//            pro.load(new FileReader("src/jdbc.properties"));
            //获取数据,赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 静态方法方便调用
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
