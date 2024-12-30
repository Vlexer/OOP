import java.io.*;
import java.net.*;

class Client {
	public static void main (String [] args) {
		
		
		try (Socket s1 = new Socket("localhost", 8080);
		BufferedReader ServerInput = new BufferedReader(new InputStreamReader(s1.getInputStream()));
		BufferedWriter ServerOutput = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
		BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));){
			
			Thread listener = new Thread(() -> {
				try {
					String message;
				while ( (message = ServerInput.readLine()) != null ) {
					System.out.println("Result from Server : " + message);
				}
				} catch ( IOException e) {
					System.out.println("Disconnected from Server");
				}
				

			});
			listener.start();
			String message;
			while ( (message = userinput.readLine()) != null ) {
				ServerOutput.write(message + "\n");
				ServerOutput.flush();	
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}