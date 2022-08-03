package TextBrowser;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBrowser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter url you want to search : ");

        String urls = sc.nextLine();
        try {
            // URL homepage = new URL("https://www.gtu.ac.in/");
            URL homepage = new URL(urls);
            URLConnection homepageconnection = homepage.openConnection();

            System.out.println("Content Length : " + homepageconnection.getContentLength());
            System.out.println("Content Encoding : " + homepageconnection.getContentEncoding());
            System.out.println("Content Type : " + homepageconnection.getContentType());

            InputStream connection = homepageconnection.getInputStream();

            int c;
            String content = "";
            while ((c = connection.read()) != -1) {
                content += (char) c;
            }
            // System.out.println("Content : " + content);

            ArrayList<String> result = new ArrayList<>();

            String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            // String regex = "<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(content);

            while (m.find()) {
                result.add(m.group());
            }

            for (String l : result) {
                System.out.println(l);
            }

            System.out.println("Total Links Are : " + result.size());
            connection.close();

        } catch (Exception e) {
            System.out.println("Connection Error!");
        }
    }
}
