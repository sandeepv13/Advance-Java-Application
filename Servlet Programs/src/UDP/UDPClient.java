import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    public static void main(String args[]){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress ip = InetAddress.getByName("localhost");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            System.out.print("Enter sentence you want to send : ");
            String sentence = br.readLine();
            sendData = sentence.getBytes(StandardCharsets.UTF_8);

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 5555);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            clientSocket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("From Server : " + modifiedSentence);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
