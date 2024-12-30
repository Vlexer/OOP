import java.io.*;
import java.net.*;

class Server {
	
	public static void main (String args[]) {
		
		try (ServerSocket server = new ServerSocket(8080);) {
			System.out.println("Server started");
			Socket socket = server.accept();
			System.out.println("Client Connected");
			new Thread(new ClientHandler(socket)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}