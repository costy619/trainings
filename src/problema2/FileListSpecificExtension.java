package problema2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class FileListSpecificExtension {
    public static void main(String[] args) throws FileNotFoundException
    {
        String extensie = ".docx";

    File file = new File("C:\\Users\\constantinb\\Documents");

    ArrayList<String> files = new ArrayList<>( 200);

for (int i = 0; i < 100; i++) {
        if (files.get(i).endsWith(extensie)) {
            files.add(files.get(i));
        }
    }

for (int i=0;i<=files.size();i++) {
        try{
            System.out.println(files.get(i));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("nu mai sunt fisier de tip " + extensie);
        }
    }

}
}



