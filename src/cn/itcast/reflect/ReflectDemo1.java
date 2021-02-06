package cn.itcast.reflect;

import cn.itcast.domain.Person;
import cn.itcast.domain.Student;

public class ReflectDemo1 {
    /**
     * 3 ways to obtain Class object
     * 1. Class.forName("FullClassName"):load bytecode files into memory, return Class object
     * 2. ClassName.class: obtain through the attribute of class
     * 3. Object.getClass(): getClass() method is inherited from Object class.
     */
    public static void main(String[] args) throws Exception{
        //1.FullClassName should include package name
        // mainly used in configuration file. Read file => load class
        Class cls1 = Class.forName("cn.itcast.domain.Person");
        System.out.println(cls1);

        //2.
        // mainly used in passing parameter
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.
        //mainly used in obtaining bytecode
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //use "==" to compare three objects(compare address they are all true!!!)
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);

        Class c = Student.class;
        System.out.println(c == cls1);
    }


}
