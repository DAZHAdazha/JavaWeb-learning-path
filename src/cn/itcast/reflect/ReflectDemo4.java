package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Method;


public class ReflectDemo4 {

    public static void main(String[] args) throws Exception {
        //0.get the oject of class Person'
        Class personClass = Person.class;

        //get method by specific name
        //两个要素方法名以及对应参数
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        eat_method.invoke(p);
        //注意参数为String.class
        Method eat_method2 = personClass.getMethod("eat",String.class);
        eat_method2.invoke(p,"race");
        System.out.println("----------------");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            //此时会打印出继承的Object的隐藏的方法
            System.out.println(method);
            //obtain method name
            String name = method.getName();
            System.out.println(name);
//            method.setAccessible(true);//同理暴力反射
        }
        //obtain class name
        String className = personClass.getName();
        System.out.println(className);
    }

}
