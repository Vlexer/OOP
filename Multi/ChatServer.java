import java.io.*;
import java.net.*;

class ChatSerer {
	public static void main (String [] args) {
		
		try (ServerSocket server = new ServerSocket(8080);
		) {
			System.out.println("Server Started");
			Socket s1 = server.accept();
			System.out.println("Client Connected");
			Socket s2 = server.accept();
			System.out.println("Client Disconnected");
			new Thread(new ClientHandler(s1, s2)).start();
			new Thread(new ClientHandler(s2, s1)).start();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
}