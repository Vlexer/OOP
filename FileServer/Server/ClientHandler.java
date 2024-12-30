import java.io.*;
import java.net.*;
import java.util.*;
class ClientHandler implements Runnable {
	Socket client;
	ClientHandler (Socket client) {
		this.client = client;
	}
	public void run () {
		try (
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter clientOutput = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			Scanner sc = new Scanner(new File("File1.txt"));
		) {
			while ( sc.hasNext() ) {
				String s = sc.next();
				clientOutput.write(s + "\n");
				clientOutput.flush();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}