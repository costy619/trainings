package problema2;

import java.io.File;
import java.io.FilenameFilter;

public class FileListSpecificExtension {
    public static void main(String a[]) {
        String extensie=".docx";
        File file = new File("C:\\Users\\constantinb\\Documents\\");
        String[] fileList = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().endsWith(extensie))
                    return true;
                else{
                    return false;
                }
            }
        });
        for (int i=0;i<=fileList.length;i++) {

           try{
               System.out.println(fileList[i]);
           }
           catch (ArrayIndexOutOfBoundsException e){
               System.out.println("nu mai sunt fisier de tip " + extensie);
           }
        }
    }
}

