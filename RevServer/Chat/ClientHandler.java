import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
	Socket sender;
	Socket receiver;
	ClientHandler ( Socket sender, Socket receiver ) {
		this.sender = sender;
		this.receiver = receiver;
	}
	public void run () {
		try (BufferedReader senderInput = new BufferedReader(new InputStreamReader(sender.getInputStream()));
		BufferedWriter receiverOutput = new BufferedWriter(new OutputStreamWriter(receiver.getOutputStream()));
		
	){
		String message;
		while ( (message = senderInput.readLine()) != null ) {
			System.out.println("Client : " + message);
			receiverOutput.write(message + "\n");
			receiverOutput.flush();
		
		}	
		} catch ( Exception e ) {
			System.out.println("Disconnected");
		}
	
	}
}