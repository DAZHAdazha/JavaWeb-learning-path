package cn.itcast.proxy;

/**
 * 真实类
 */
public class Lenovo implements SellComputer{

    @Override
    public String sell(double money) {
        System.out.println("花了" + money + "买了电脑");
        return "电脑";
    }

    @Override
    public void show() {
        System.out.println("show....");
    }
}
