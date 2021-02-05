package cn.itcast.junit;

public class CalculatorTest {
    public static void main(String[] args) {
        // previous method:
        // create object
        Calculator c = new Calculator();
        // call
        int result = c.add(1,2);
        System.out.println(result);
        int result2 = c.sub(1,2);
        System.out.println(result2);

    }
}
