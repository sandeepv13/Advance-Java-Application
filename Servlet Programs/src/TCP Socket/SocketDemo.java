import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        try {
            Socket gtu = new Socket("gtu.ac.in", 443);
            OutputStream gtuoutputstream = gtu.getOutputStream();
//            gtuoutputstream.write("GET/HTTP/1.1\n\r\n\r".getBytes());
            InputStream gturesponse = gtu.getInputStream();

            int c;
            StringBuilder content = new StringBuilder();
            while((c = gturesponse.read()) != -1)
            {
                content.append((char) c);
            }
            System.out.println(content);

        }catch (Exception e){
            System.out.println("System Error!");
        }
    }
}
