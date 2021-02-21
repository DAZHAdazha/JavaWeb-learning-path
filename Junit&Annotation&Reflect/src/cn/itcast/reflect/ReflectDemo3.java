package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;


public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {
        //0.get the oject of class Person'
        Class personClass = Person.class;
        //注意参数为String.class和int.class
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //create object
        Object person = constructor.newInstance("Jon", 21);
        System.out.println(person);

        System.out.println("---------------");
        //这种写法有点麻烦
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        Object person1 = constructor1.newInstance();
        System.out.println(person1);
        //下面代码为简化版，与上面等价(空参构造器)
        Object o = personClass.newInstance();
        System.out.println(o);
        //构造器也可以暴力反射
        constructor1.setAccessible(true);

    }

}
