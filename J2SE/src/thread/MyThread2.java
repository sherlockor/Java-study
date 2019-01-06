package thread;

public class MyThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int index = 0; index < 100; index++) {
			System.out.println(index);
		}
	}

}
