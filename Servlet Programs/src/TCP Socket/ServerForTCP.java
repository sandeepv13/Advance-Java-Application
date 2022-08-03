import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class ServerForTCP {
    public static void main(String args[]){
        try {
            ServerSocket ss = new ServerSocket(1111);
            Socket s = ss.accept();

            DataInputStream dataIn = new DataInputStream(s.getInputStream());
            String str = (String) dataIn.readUTF();
            System.out.println(str);
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
