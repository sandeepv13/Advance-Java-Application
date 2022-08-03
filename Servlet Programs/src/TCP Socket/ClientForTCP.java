import java.io.DataOutputStream;
import java.net.Socket;

public class ClientForTCP {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 1111);
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
            dataOut.writeUTF("hello Server");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
