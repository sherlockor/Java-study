package unitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SumUnit {
    @Before
    public void before() {
        System.out.println("before");
    }
    @After
    public void after() {
        System.out.println("after");
    }
    @Test
    public void testSum1() {
        int result = sum1(99, 100);
        Assert.assertEquals(result, 299);
    }
    @Test
    public void testSum2() {
        int result = sum2(1, 2, 3);
        Assert.assertEquals(result, 6);
    }

    public int sum1(int a, int b) {
        return a+b;
    }
    public int sum2(int a, int b, int c) {
        return a+b+c;
    }
}
