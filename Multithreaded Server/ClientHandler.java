import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
	Socket sender;
	Socket receiver;

	ClientHandler (Socket s1, Socket s2) {
		this.sender = s1;
		this.receiver = s2;
	}
	
	public void run (){
		try (BufferedReader senderInput = new BufferedReader(new InputStreamReader(sender.getInputStream()));
		BufferedWriter receiverOutput = new BufferedWriter(new OutputStreamWriter(receiver.getOutputStream()));
) {
		String message;
		while ((message = senderInput.readLine()) != null) {
			receiverOutput.write("Message from peer " + message + "\n");
			receiverOutput.flush();
		}
	
	} catch (IOException  e) {
		System.out.println("Client disconnected");
		}
	}		
	

}