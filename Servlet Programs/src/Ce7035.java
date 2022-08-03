import java.net.InetAddress;
import java.util.*;

public class Ce7035 {
    public static void main(String args[])
    {
        try{
            InetAddress[] mypc = InetAddress.getAllByName("Dishen"); // all ip Address
            for(InetAddress ip:mypc)
                System.out.println(ip);

            InetAddress mysys = InetAddress.getLocalHost(); // my local ip Address
            System.out.println("MY " + mysys.getHostAddress());
            System.out.println("MY " + mysys.getHostName());
            System.out.println("MY " + mysys);
        }catch (Exception e) {
            System.out.println("Error Occurs!");
        }

        try{
            InetAddress[] mypc = InetAddress.getAllByName("gtu.ac.in");
            for(InetAddress ip:mypc)
                System.out.println(ip);
        }catch (Exception e) {
            System.out.println("Error Occurs!");
        }
    }
}
