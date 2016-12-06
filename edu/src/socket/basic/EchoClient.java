package socket.basic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class EchoClient {
	public static final String IP = "127.0.1.1";
	
	public static void send() throws UnknownHostException, IOException, ClassNotFoundException{
		Socket clientSocket = new Socket(IP, EchoServer.MYECHOPORT);
		ObjectOutputStream objOut = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
		
		System.out.print("Send something to the server: ");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		objOut.writeObject(str);
		
		String received = (String) in.readObject();
		System.out.println(received);
		
		input.close();
		in.close();
		objOut.close();
		clientSocket.close();
	}
	
	public static void main(String argv[]) throws UnknownHostException, IOException, ClassNotFoundException{
		EchoClient.send();
	}
	
}
