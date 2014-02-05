import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Decoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket MyService = null;
		Socket serviceSocket = null;
		BufferedReader input;
		DataOutputStream output;
		String inputString;
	    try {
	       MyService = new ServerSocket(3000);
	       serviceSocket = MyService.accept();
	       input = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
	       output = new DataOutputStream(serviceSocket.getOutputStream());
	       while (true) {
	    	   //System.out.println("Tester2");
	    	   inputString = input.readLine();
	    	   System.out.println("First:" + inputString);
				if ( inputString.equals("request-to-send") ) {
					output.writeUTF("clear-to-send");
					System.out.println(inputString);
					break;
				}
	       }
	       while (true) {
	    	   inputString = input.readLine();
	    	   System.out.println(inputString);
	    	   break;
	       }
	       output.close();
	       input.close();
	       serviceSocket.close();
	       MyService.close();
	        }
	        catch (IOException e) {
	           System.out.println("Decoder Exception" + e);
	        }
	}

}
