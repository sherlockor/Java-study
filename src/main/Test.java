package main;

import java.io.IOException;
import file.FileOperator;
import thread.*;

public class Test {
	public static void main(String[] args) throws IOException {
		MyThread1 my_thread = new MyThread1();
		//my_thread.start();
		
		MyThread2 my_thread2 = new MyThread2();
		Thread thread = new Thread(my_thread2);
		thread.start();
		
		System.out.println("Finished");
	}
}
