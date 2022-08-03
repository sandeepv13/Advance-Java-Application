import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
    public static void main(String args[]) {
        try {
            URL url = new URL("https://www.gtu.ac.in/");
            URLConnection urlCon = url.openConnection();
            InputStream dataIn = urlCon.getInputStream();

            int c;
            StringBuilder content = new StringBuilder();
            while ((c = dataIn.read()) != -1) {
                content.append((char) c);
            }

            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
