import java.net.InetAddress;
import java.util.*;

public class Demo {
    public static void main(String args[]) {
        InetAddress[] ip = InetAddress.getAllByName("gtu.ac.in");
        for (InetAddress x : ip) {
            System.out.println(x.toString());
        }
    }
}