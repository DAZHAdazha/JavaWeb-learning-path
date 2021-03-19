package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();

        //2.动态代理增强lenovo对象
        /**
         * 三个参数
         *  1.类加载器：真实对象.getClass().getClassLoader()
         *  2.接口数组：真实对象getClass().getInterfaces()
         *  3.处理器： new InvocationHandler()
         */
        SellComputer proxy_lenovo = (SellComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
             * @param proxy：代理对象
             * @param method：代理对象调用的方法，被封装为的对象
             * @param args：代理对象调用方法是，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("该方法执行了...");
                System.out.println(method.getName());
                if(args != null){
                    System.out.println(args[0]);
                }


                //判断是否是sale方法
                if (method.getName().equals("sell")) {
                    //1.增强参数
                    double money = (double) args[0];
                    money = money * 0.85;

                    System.out.println("专车包邮");

                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);

                    System.out.println("免费上门");

                    //2.增强返回值
                    return obj + "_送鼠标垫";
                } else {
                    //使用真实对象调用该方法
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        //3.调用方法
        String computer = proxy_lenovo.sell(8000);
        proxy_lenovo.show();
        System.out.println(computer);
    }
}
