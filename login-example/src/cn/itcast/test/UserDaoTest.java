package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("JdbcTemplate");
        loginUser.setPassword("DruidTestPassword");
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
