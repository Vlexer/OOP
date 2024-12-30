import java.io.*;
import java.net.*;

class ChatClient {
	public static void main (String [] args) {
		
		try (Socket s1 = new Socket("localhost", 8080);
		BufferedReader serverInput = new BufferedReader(new InputStreamReader(s1.getInputStream()));
		BufferedWriter serverOutput = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));) {
			
			System.out.println("Connected to Server ");
			Thread listener = new Thread( () -> {
				
				try {
					String message;
					while ( (message = serverInput.readLine()) != null ) {
					System.out.println("Message from Peer " + message);
					} 
				} catch ( IOException e ) {
					System.out.println("Disconnected from Server");
				}
			});
			listener.start();
			String message;
			while ( (message = userInput.readLine()) != null ) {
				serverOutput.write(message + "\n");
				serverOutput.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}