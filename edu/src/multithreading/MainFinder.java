package multithreading;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 *  @author Gaetano F. Anastasi
 *
 */
public class MainFinder {
	static List<String> lines;
	static String textFile = "pinocchio.txt";
	static String toFind = "Geppetto";
	
	static void readFileByLine(String path, Charset encoding) throws IOException {
		lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
	}
	
	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	static void n_thread(int num_thread) throws IOException, InterruptedException {
		// TODO: dear student, implement the general method for generating n threads
	}
	
	static void two_thread() throws IOException, InterruptedException {
		int i = 0;
		String part1="", part2="";
		readFileByLine(textFile, StandardCharsets.UTF_8);
		int num_lines = lines.size();
		
		// iteration for each lines of the file to split it
		for (String s : lines) {
			if (num_lines / 2 < i)
				part1 += s;
			else
				part2 += s;
			i++;
		}
		
		MyThread t1 = new MyThread(part1, toFind);
		MyThread t2 = new MyThread(part2, toFind);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Occurencies: " + (t1.getOccurencies() + t2.getOccurencies()));
	}
	
	static void single_thread() throws IOException, InterruptedException {
		String part1="";
		readFileByLine(textFile, StandardCharsets.UTF_8);
		
		// iteration for each lines of the file
		for (String s : lines) {
			part1 += s;
		}
		
		MyThread t1 = new MyThread(part1, toFind);
		t1.start();
		t1.join();
		System.out.println("Occurencies: " + (t1.getOccurencies()));
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		long start = System.currentTimeMillis();
		two_thread();
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.000");
		System.out.print("Execution time with two threads is " + formatter.format((end - start) / 1000d) + " seconds\n");
		
		start = System.currentTimeMillis();
		single_thread();
		end = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.000");
		System.out.print("Execution time with one thread is " + formatter.format((end - start) / 1000d) + " seconds\n");
	}
}
