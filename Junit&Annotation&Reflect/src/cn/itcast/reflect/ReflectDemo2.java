package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {
        //0.get the oject of class Person'
        Class personClass = Person.class;
        //1.get member variables
        //Filed[] getFileds(), only get all public fileds
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("----------------");

        Field a = personClass.getField("a");
        // get the value of "a"
        Person p = new Person();
        Object value = a.get(p);
        // default value of "a" is null
        System.out.println(value);
        a.set(p,"newValue");
        System.out.println(p);
        System.out.println("----------------");
        // get all member variables
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        // can also set private variables!!!
        Field d = personClass.getDeclaredField("d");
        // 忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

    }

}
