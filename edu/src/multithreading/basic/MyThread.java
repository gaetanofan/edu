package multithreading.basic;

/**
 *  @author Gaetano F. Anastasi
 *
 */
public class MyThread extends Thread {

	static int counter = 0;
	int id = 0;

	synchronized int increment(){
		return counter++;
	}

	MyThread(){
		id = increment();
	}

	public void run(){
		System.out.println("Thread #" + id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("Thread #" + id + " terminated");
	}
}
