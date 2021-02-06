package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class CalculatorTest {

    /**
     * initial method
     * to require resource, all test methods should be executed after this initial process
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * free resource
     * all test methods will run this method after their execution
     */
    @After
    public void close(){
        System.out.println("end..");
    }

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
