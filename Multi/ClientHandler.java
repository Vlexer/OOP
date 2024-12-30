import java.io.*;
import java.net.*;


class ClientHandler implements Runnable {
	Socket sender;
	Socket receiver;	
	ClientHandler (Socket s1, Socket s2) {
		sender = s1;
		receiver = s2;
	}
	public void run() {
		
		try (BufferedReader senderInput = new BufferedReader(new InputStreamReader(sender.getInputStream()));
		BufferedWriter receiverOutput = new BufferedWriter(new OutputStreamWriter(receiver.getOutputStream()));)
		 {
			String message;
			while ( (message = senderInput.readLine()) != null ) {
				System.out.println("Client sent " + message);
				receiverOutput.write(message + "\n");
				receiverOutput.flush();
			}
		} catch (Exception e) {
			System.out.println("Client Disconnected");	
		}	
	}
}