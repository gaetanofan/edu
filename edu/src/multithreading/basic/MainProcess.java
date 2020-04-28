package multithreading.basic;

/**
 *  @author Gaetano F. Anastasi
 *
 */
public class MainProcess {

	public static void main(String[] args) throws InterruptedException{
	    MyThread t1 = new MyThread();
	    MyThread t2 = new MyThread();
	    MyThread t3 = new MyThread();
	    
	    t1.start();
	    t2.start();
	    t3.start();
	    
	    Thread.sleep(1000);
	    
	    t1.join();
	    t2.join();
	    t3.join();
	  }
}
