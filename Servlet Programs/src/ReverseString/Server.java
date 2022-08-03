
// This server is for ReverseString Program.

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Port Number : ");
            int port = sc.nextInt();
            sc.nextLine();

            System.out.println("Server is running ... !");
            ServerSocket ss = new ServerSocket(port);

            new ChatServers(ss.accept());

        } catch (Exception e) {
            System.out.println("Server Error : " + e);
        }
    }
}

class ChatServers extends Thread {
    Socket s;

    public ChatServers(Socket socket) {
        s = socket;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        receive();
    }

    public void receive() {
        try {
            while (true) {

                DataInputStream dataIn = new DataInputStream(s.getInputStream());
                String str = dataIn.readUTF();

                StringBuffer rev = new StringBuffer();
                rev.append(str);
                rev = rev.reverse();
                String revStr = new String(rev);

                DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
                dataOut.writeUTF(revStr);

            }
        } catch (Exception e) {
            System.out.println("Server Error \n" + e);
        }
    }
}
