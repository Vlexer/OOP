import java.io.*;
import java.net.*;

class Server {
	public static void main (String [] args) {
		
		try(ServerSocket server = new ServerSocket(8080);) {
			System.out.println("Server Startedd");
			Socket s1 = server.accept();
			System.out.println("Client Connected");
			
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			BufferedWriter clientOutput = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));			
			String message;
			while ( (message = clientInput.readLine()) != null ) {
				StringBuilder res = new StringBuilder();
				res.append(message);
				res.reverse();
				clientOutput.write(res + "\n");
				clientOutput.flush();
			}
			
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}