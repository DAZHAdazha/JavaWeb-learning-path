package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    /**
     * Test for addition method
     */
    @Test
    public void testAdd(){
        System.out.println("executing.");
        // create object
        Calculator c = new Calculator();
        // call
        int result = c.add(1,2);
        System.out.println(result);
        // assert
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        System.out.println("executing.");
        // create object
        Calculator c = new Calculator();
        // call
        int result = c.sub(1,2);
        System.out.println(result);
        // assert
        Assert.assertEquals(-1,result);
    }
}
