
// First run Server.java File with any port number and use that port to connect with client to get Reverse String of Input.

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your port : ");
            int port = sc.nextInt();
            sc.nextLine();

            Socket s = new Socket("localhost", port);

            if (s.isConnected()) {
                System.out.println("Connected to Server....");
            }

            while (true) {
                System.out.print("Enter String to reverse : ");
                String inputStr = sc.nextLine();

                DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
                dataOut.writeUTF(inputStr);

                DataInputStream dataIn = new DataInputStream(s.getInputStream());
                String revStr = dataIn.readUTF();

                System.out.println("Reversed String : " + revStr);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Client System Error!\n" + e);
        }
        sc.close();
    }
}
