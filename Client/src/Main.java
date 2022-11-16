import java.net.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int port = 5000;
        Socket socket = null;
        try {
            socket = new Socket("localhost", port);
            System.out.println("Connected");

            BufferedReader inputStream = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            PrintWriter outputStream = new PrintWriter(socket.getOutputStream(),true);

            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName = "empty";

            do {
                if(clientName.equals("empty")) {
                    System.out.println("Enter your name:");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                    outputStream.println(userInput);
                    if(userInput.equals("exit")) {
                        break;
                    }
                }
                else {
                    String message = ("(" + clientName +")" + " message : ");
                    System.out.println(message);
                    userInput = scanner.nextLine();
                    outputStream.println(message + " "+ userInput);
                    if(userInput.equals("exit")) {
                        break;
                    }
                }
            }
            while(!userInput.equals("exit"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}