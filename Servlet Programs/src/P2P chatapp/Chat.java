import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        String host = "";
        int port = 0;
        String im = "";

        System.out.println("Enter port you want to start : ");
        int serverPort = Integer.parseInt(in.nextLine());

        System.out.println("Server started Listening on port " + serverPort + "...!");
        new ChatServer(serverPort);

        while (true) {
            if (host.equals("")) {
                System.out.println("Enter cool Name : ");
                im = in.nextLine();
                host = "localhost";
                System.out.println("Enter Port to chat with : ");
                port = in.nextInt();
            }
            String msg = im + ": " + in.nextLine();
            send(msg, host, port);
        }
    }

    public static void send(String msg, String rhost, int rport) throws Exception {
        Socket client = new Socket(rhost, rport);
        OutputStream os = client.getOutputStream();
        os.write(msg.getBytes());
        client.close();
    }
}

class ChatServer implements Runnable {
    int port = 0;

    public ChatServer(int port) {
        this.port = port;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        receive();
    }

    public void receive() {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                InputStream is = client.getInputStream();
                int c;
                String msg = "";
                while ((c = is.read()) != -1) {
                    msg += (char) c;
                }
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
