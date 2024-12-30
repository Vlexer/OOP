import java.io.*;
import java.net.*;

class Client {
	public static void main(String args[]) {
		try (Socket socket = new Socket("localhost", 8080);
		BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter serverOutput = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
) {	
		System.out.println("Connected to server");
		Thread listener = new Thread(() -> {
			try {
				String message;
				while ( (message = serverInput.readLine()) != null ) {
					System.out.println(message);
				}
 			} catch (IOException e) {
				System.out.println("Disconnected");
			}
			
		});	
		listener.start();
		String userMessage;
		while ( (userMessage = userinput.readLine()) != null) {

			serverOutput.write(userMessage + "\n");
			serverOutput.flush();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}