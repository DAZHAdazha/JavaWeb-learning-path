package cn.itcast.datasource.jdbcTemplate;

import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "update users set username = 'JdbcTemplate' where id = ?";
        int count = template.update(sql,8);// 8代表第一个问号，如有多个参数直接在后边用逗号连接即可
        System.out.println(count);
        //不用释放资源，归还连接，template会自动完成这些操作
    }
}
