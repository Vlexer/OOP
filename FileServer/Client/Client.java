import java.io.*;
import java.net.*;
import java.util.*;

class Client {
	public static void main (String args[]) {
		try (
			Socket s = new Socket("localhost", 8080);
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
						
		) {
			String message;
			while ( (message = serverInput.readLine()) != null ) {
				System.out.println(message);
			}	
			
				
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}