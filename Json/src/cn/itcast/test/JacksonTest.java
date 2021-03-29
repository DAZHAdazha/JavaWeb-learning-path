package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //1.创建Person对象
        Person person = new Person();
        person.setName("dazha");
        person.setAge(21);
        person.setGender("男");

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //3.转换

        /*
            转换方法
            writeValue(参数1，obj):
                参数1:
                    File:将obj对象转为JSON字符串，并保存到指定文件中
                    Writer：将obj对象转为JSON字符串，并将json数据填充到字符输出流中
                    OutputStream：将obj对象转为JSON字符串，并将json数据填充到字节输出流中
            writeValueAsString(obj):将对象转为json字符串
         */
        //{"name":"dazha","age":21,"gender":"男"}
        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);

        //writeValue,将数据写到d://a.txt中
//        objectMapper.writeValue(new File("d://a.txt"),person);

        //writeValue.将数据关联到Writer中
        objectMapper.writeValue(new FileWriter("d://b.txt"),person);

    }

    @Test
    public void test2() throws IOException {
        //1.创建Person对象
        Person person = new Person();
        person.setName("dazha");
        person.setAge(21);
        person.setGender("男");
        person.setBirthday(new Date());

        //2.转换
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);//{"name":"dazha","age":21,"gender":"男","birthday":1617024666528}
        System.out.println(json);
    }

    @Test
    public void test3() throws IOException {
        //1.创建Person对象
        Person person = new Person();
        person.setName("dazha");
        person.setAge(21);
        person.setGender("男");
        person.setBirthday(new Date());

        Person person1 = new Person();
        person1.setName("dazha");
        person1.setAge(21);
        person1.setGender("男");
        person1.setBirthday(new Date());

        //1.创建Person对象
        Person person2 = new Person();
        person2.setName("dazha");
        person2.setAge(21);
        person2.setGender("男");
        person2.setBirthday(new Date());

        //创建List集合
        List<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person1);
        list.add(person2);

        //2.转换
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        //[{"name":"dazha","age":21,"gender":"男","birthday":"2021-03-29"},{"name":"dazha","age":21,"gender":"男","birthday":"2021-03-29"},{"name":"dazha","age":21,"gender":"男","birthday":"2021-03-29"}]
        System.out.println(json);
    }

    @Test
    public void test4() throws IOException {

        //1.创建Map对象
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","dazha");
        map.put("age",21);
        map.put("gender","男");

        //2.转换
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map);
        //{"gender":"男","name":"dazha","age":21}
        System.out.println(json);
    }

    @Test
    public void test5() throws IOException {
        //JSON字符串转为Java对象
        String json = "{\"gender\":\"男\",\"name\":\"dazha\",\"age\":21}";

        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //3.转换为Java对象Person对象
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
