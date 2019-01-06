package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCase.class})
public class TestCase {
	
	public int Sum(int a, int b) {
		return (a + b);
	}
	public int Sum2(int a, int b, int c) {
		return (a + b + c);
	}
	@Test
	public void TestSum() {
		int result = Sum(1, 2);
		Assert.assertEquals(result, 3);
	}
	@Test
	public void TestSum2() {
		int result = Sum2(1, 2, 3);
		Assert.assertEquals(result, 6);
	}
	//测试开始之前执行
	@Before
	public void before() {
		System.out.println("before");
	}
	//测试完成之后执行
	@After
	public void after() {
		System.out.println("after");
	}
}
