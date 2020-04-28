package socket.basic;

import java.io.*;
import java.net.*;

public class EchoServer {
	
	public static int MYECHOPORT = 8189;
	public static int backlog_queue = 5; //maximum queue length for incoming connections

	public static void main(String argv[]) throws ClassNotFoundException, IOException {
		ServerSocket s = null;
		try {
			System.out.println("[" + EchoServer.class.getName() + "]");
			InetAddress bindAddr = InetAddress.getLocalHost(); // IP reale della macchina
			
			try {
				s = new ServerSocket(MYECHOPORT, backlog_queue, bindAddr);
			}
			catch (Exception e) {
				bindAddr = InetAddress.getLoopbackAddress(); //127.0.0.1
				s = new ServerSocket(MYECHOPORT, backlog_queue, bindAddr);
			}
			
			System.out.println("Listening for incoming connections on " + 
					bindAddr.getHostAddress() + ':' + MYECHOPORT);

			while (true) {
				System.out.print("... ");
				Socket incoming = null;
				try {
					incoming = s.accept();
				} catch(IOException e) {
					System.out.println(e);
					continue;
				}
				try {
					incoming.setSoTimeout(10000); // 10 seconds
				} catch(SocketException e) {
					e.printStackTrace();
				}

				System.out.println("accepted connection from client " + incoming.getInetAddress());
				try {
					handleSocket(incoming);
				} catch(InterruptedIOException e) {
					System.out.println("Error: " + e.getMessage());
				}

				incoming.close(); 
			}
		}
		finally{
			if (s != null) {
				s.close();
			}
		}
	}

	public static void handleSocket(Socket incoming) throws ClassNotFoundException, IOException {
		ObjectInputStream  inFromClient  = new ObjectInputStream(incoming.getInputStream()); 
		ObjectOutputStream outToClient = new ObjectOutputStream(incoming.getOutputStream()); 

		String str = (String) inFromClient.readObject();
		if (str != null) {
			outToClient.writeObject("You sent to server: " + str);
		}
		else {
			outToClient.writeObject("You sent to server null string");
		}
		outToClient.close();
		inFromClient.close();
	}
}
