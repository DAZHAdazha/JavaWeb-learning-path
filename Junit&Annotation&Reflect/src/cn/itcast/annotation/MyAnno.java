package cn.itcast.annotation;

public @interface MyAnno {
    //注解抽象方法返回值不能为void或者类
    public abstract int age();
    String name();
    String gender() default "male";//可以给默认值
    //public abstract可以省略
//    String show2();
//
    Person per();
    MyAnno2 anno2();
//
    String[] strs();

}
