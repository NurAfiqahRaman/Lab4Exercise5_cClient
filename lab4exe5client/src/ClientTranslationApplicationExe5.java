import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTranslationApplicationExe5 {
	public static void main(String[]args) {
		
		try {
			//Connect to the server at localhost, port 1223
			Socket clientSocket=new Socket (InetAddress.getLocalHost(),1223);
			
			PrintWriter pr=new PrintWriter(clientSocket.getOutputStream());
			pr.println("good morning in bahasa melayu");
			pr.flush();
			
			//Create input stream
			BufferedReader bufferedReader=new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			
			//Read from the network and display the current date
			String text =bufferedReader.readLine();
			System.out.println("server : "+text);
			
			//Close everything
			bufferedReader.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
