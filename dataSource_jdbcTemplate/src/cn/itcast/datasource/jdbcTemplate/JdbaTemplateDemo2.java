package cn.itcast.datasource.jdbcTemplate;

import Utils.JDBCUtils;
import domain.Users;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbaTemplateDemo2 {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //Junit单元测试，让方法独立执行
    @Test
    public void test1() {
        //查询id为1的记录 将其封装为Map集合
        //注意这个方法查询结果长度只能是1！！！,将列名作为key，将值作为value,将这条记录封装为一个map集合
        String sql = "select * from users where id = ? ";
        Map<String,Object> map = template.queryForMap(sql,1);
        System.out.println(map);
    }
    @Test
    public void test2() {
        //查询所有的记录 将其封装为List集合
        String sql = "select * from users";
        //注意这个list！！！是map对象的list
        //将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
        List<Map<String,Object>> list = template.queryForList(sql);
        System.out.println(list);
    }
    @Test
    public void test3() {
        //查询所有的记录 将其封装为Users对象的List集合
        String sql = "select * from users";
        //匿名类自己实现RowMapper
        List<Users> list = template.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users user = new Users();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user.setId(id);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                return user;
            }
        });
        for (Users users : list) {
            System.out.println(users);
        }
    }

    @Test
    public void test4(){
        //查询所有的记录 将其封装为Users对象的List集合，同上一个test3功能一样
        String sql = "select * from users";
        //使用提供的RowMapper，简化操作
        //注意有可能会有Null的报错，原因是Users类中基本数据类型需要用引用类型来定义，比如将int id =>（改为） Integer id,
        //double xxx => Double xxx
        List<Users> list = template.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
        for (Users users : list) {
            System.out.println(users);
        }
    }

    @Test
    public void test5(){
        //查询总记录数
        String sql = "select count(id) from users";
        //queryForObject通常使用聚合函数
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }

}
