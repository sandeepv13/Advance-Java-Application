import java.net.*;
import java.io.*;
import java.util.Scanner;


public class ReverseStringServer {

    public static void main(String args[]) {
        try {
            Scanner sc=new Scanner(System.in);

//            System.out.println("Enter Port Number : ");
//            int port = sc.nextInt();
//            sc.nextLine();

            ServerSocket ss = new ServerSocket(4444);
            Socket s = ss.accept();

            DataInputStream st = new DataInputStream(s.getInputStream());
            System.out.println("Connected to client");

            String str = (String) st.readUTF();
            System.out.println("String is " + str);
            StringBuilder sb = new StringBuilder(str);
            System.out.println("Reverse string is: " + sb.reverse());
            ss.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}