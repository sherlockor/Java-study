package thread;

public class MyThread1 extends Thread {
	public void run() {
		for(int index = 0; index < 100; index++) {
			System.out.printf("MyThread1 %d",index);
		}
	}
}
