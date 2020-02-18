package Tema6ex1;

import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C:\\Users\\constantinb\\Documents\\url.txt");
        List<String> links = HTMLUtils.extractLinks(reader);
        for (String link : links) {
            System.out.println(link.trim());
        }
    }
}
