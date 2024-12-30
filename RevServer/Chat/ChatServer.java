import java.io.*;
import java.net.*;


class ChatServer {
	public static void main (String args[]) {
		try (ServerSocket server = new ServerSocket(8080)) {
		System.out.println("Server Started");
		Socket s1 = server.accept();	
		Socket s2 = server.accept();
		
		new Thread(new ClientHandler(s1, s2)).start();
		new Thread(new ClientHandler(s2, s1)).start();
	} catch (Exception e) {
		;
	}

	}
	
}