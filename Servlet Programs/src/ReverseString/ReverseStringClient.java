import java.io.*;
import java.net.*;
import java.util.Scanner;


public class ReverseStringClient {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Port Number to Chat with : ");
        int port = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter string : ");
        String sl = sc.next();

        try {
            Socket s = new Socket("localhost", port);
            System.out.println("connected");
            DataOutputStream st = new DataOutputStream(s.getOutputStream());
            st.writeUTF(sl);
            st.close();
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
