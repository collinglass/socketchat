import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Encoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket MyClient;
		DataOutputStream output;
		BufferedReader input;
		String inputString;
		String host = "";
		
		System.out.println("Please input binary string:");
		String s = getInput();
		
		try {
			host = "Collins-MacBook-Air.local";
			MyClient = new Socket(host, 3000);
			input = new BufferedReader(new InputStreamReader(MyClient.getInputStream()));
			output = new DataOutputStream(MyClient.getOutputStream());
			
			output.writeUTF("request-to-send");
			System.out.println("Tester3");
			while (true) {
				inputString = input.readLine();
				if ( inputString.equals("clear-to-send") ) {
					output.writeUTF(s);
					break;
				}
			}
				
			output.close();
	        input.close();
	        MyClient.close();
		}
		catch(UnknownHostException e)
	      {
	         System.err.println("Cannot find host called: " + host);
	         e.printStackTrace();
	         System.exit(-1);
	      }
	      catch(IOException e)
	      {
	         System.err.println("Could not establish connection for " + host);
	         e.printStackTrace();
	         System.exit(-1);
	      }
	}
	
	private static String getInput() {
		Scanner scan = new Scanner(System.in);
		String result = "";
		try {
			int i = scan.nextInt();
			while ( i <= 1 && i >= 0 ) {
				result = result + i;
				i = scan.nextInt();
			}
		} catch (Exception e) {
			System.out.println("You entered an invalid input. You're only allowed 0 or 1 silly!");
		}
		return result;
	}
}
