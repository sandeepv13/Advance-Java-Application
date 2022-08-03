import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class UDPServer {
    public static void main(String args[]) throws SocketException {
        try {
            DatagramSocket serverSocket = new DatagramSocket(5555);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());
                System.out.println("Received : " + sentence);

                InetAddress ip = receivePacket.getAddress();
                int port = receivePacket.getPort();

                String capitalizedSentence = sentence.toUpperCase(Locale.ROOT);

                sendData = capitalizedSentence.getBytes(StandardCharsets.UTF_8);
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,ip,port);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
