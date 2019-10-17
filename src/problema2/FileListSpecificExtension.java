package problema2;

import java.io.File;
import java.io.FilenameFilter;
import java.net.CacheRequest;

public class FileListSpecificExtension {
    public static void main(String[] args) {
        String ext = ".docx";
        File file = new File("C:\\Users\\constantinb");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().endsWith(ext)) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (String f : list) {
            System.out.println(f);
        }
    }
}



