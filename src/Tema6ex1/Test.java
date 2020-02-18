package Tema6ex1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) throws IOException {
      ArrayList<String> listaCuURLdinFIsiere;
        ArrayList<String> result = new ArrayList<String>();
        ReadURLfromFile("C:\\Users\\constantinb\\Documents\\url.txt");
        ArrayList<String> readfrom=ReadURLfromFile("C:\\Users\\constantinb\\Documents\\url.txt");
        ArrayList<String> s = GettingStringsWithURLS(readfrom);
        scriereDoarLinkuri(result, s);
        ReadURLfromFile("C:\\Users\\constantinb\\Documents\\aldoilea.txt");
        ArrayList<String> readfrom1=ReadURLfromFile("C:\\Users\\constantinb\\Documents\\aldoilea.txt");
        ArrayList<String> x = GettingStringsWithURLS(readfrom1);
        scriereDoarLinkuri(result, x);
        rescriereListaInFisier(result);
    }

    private static void scriereDoarLinkuri(ArrayList<String> result, ArrayList<String> s) {
        String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        for (String d : s) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(d);
            while (m.find()) {
                result.add(m.group());
            }
        }
        for (String d : result) {
            System.out.println(d.trim());
        }
    }

    private static ArrayList<String> GettingStringsWithURLS(ArrayList<String> readfrom) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        ArrayList<String> s = new ArrayList<>();

        for (String reading : readfrom) {
            try{
            url = new URL(reading);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                if (line.contains("href=") && line.contains("https://"))
//                    System.out.println(line.trim());
                    s.add(line.trim());
            }
        } catch(MalformedURLException mue){
            mue.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        } finally{
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                //exception
            }
        }
    }
        return s;
    }

    private static ArrayList<String> ReadURLfromFile(String path) throws IOException {
        BufferedReader bra = new BufferedReader(new FileReader(path));
       ArrayList<String>list = new ArrayList<>();
        String urlLine;
        while ((urlLine = bra.readLine()) != null) {
            System.out.println(urlLine);
            list.add(urlLine);
            }
        return list;
    }
    public static void rescriereListaInFisier(ArrayList<String> tempArray) {
        try {
            try {
                PrintWriter pr = new PrintWriter("C:\\Users\\constantinb\\Documents\\aldoilea.txt");
                for (int i = 0; i < tempArray.size(); i++) {
                    pr.println((tempArray.get(i)));
                }
                pr.close();

            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu poate fi inchis");
        }
    }
}

