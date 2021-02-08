package cn.itcast.annotation;

import java.util.Date;

/**
 * JDK中预定义注解
 * @Override
 * @Deprecated
 * @SuppressWarnings
 */
@SuppressWarnings("all")
public class AnnoDemo2 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }

    //类和方法都可以压制警告
//    @SuppressWarnings("all")
    public  void show2(){
        //替代show1方法
    }

    public void demo(){
        show1();//可以调用但是过时了
        Date date = new Date();//可以调用但是过时了
    }



}
