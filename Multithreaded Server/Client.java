import java.io.*;
import java.net.*;

class ChatClient {
	public static void main (String args[]) {
		try (
		Socket socket = new Socket("localhost",8080);
		BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter serverOutput = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		){
			System.out.println("Connected To Server");
			Thread listener = new Thread(() -> {
			try {
				String message;
				while ( (message = serverInput.readLine()) != null ){
					System.out.println(message);
				}
			} catch (IOException e) {
				System.out.println("Disconnected fromServer");
			}
		});
			listener.start();
			String userMessage;
			while((userMessage = userInput.readLine()) != null) {
				serverOutput.write(userMessage + "\n");
				serverOutput.flush();
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}