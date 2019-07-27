package multithreading;

/**
 *  @author Gaetano Anastasi
 *
 */
public class MyThread extends Thread{
	private String f_content;
	private String to_find;
	private int num = 0;
	
	public MyThread (String s1, String s2){
		f_content = s1;
		to_find = s2;
	}
	
	public void run() {
		int curr_index, last_index;
		if (f_content.contains(to_find)) {
			curr_index = f_content.indexOf(to_find);
			// System.out.println(curr_index);
			
			last_index = f_content.lastIndexOf(to_find);
			// System.out.println(last_index);
			num++;
			while (curr_index != last_index) {
				num++;
				curr_index = f_content.indexOf(to_find,curr_index+to_find.length());
			}
		}
	}

	public int getOccurencies() {
		return num;
	}
}
