package Datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class DSender {
    public static void main(String args[]){
        try{
            DatagramSocket ds = new DatagramSocket();
            String str = "Message sent by Datagram Socket.";
            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(str.getBytes(StandardCharsets.UTF_8),str.length(), ip, 3000);
            ds.send(dp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
