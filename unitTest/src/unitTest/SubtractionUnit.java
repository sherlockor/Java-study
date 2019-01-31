package unitTest;

import org.junit.Assert;
import org.junit.Test;

public class SubtractionUnit {
    @Test
    public void testSubtraction1() {
        int result = subtraction1(9, 1, 2);
        Assert.assertEquals(result, 6);
    }
    @Test
    public void testSubtraction2() {
        int result = subtraction2(9, 1);
        Assert.assertEquals(result, 8);
    }
    
    public int subtraction1(int a, int b, int c) {
        return a-b-c;
    }
    public int subtraction2(int a, int b) {
        return a-b;
    }
}
