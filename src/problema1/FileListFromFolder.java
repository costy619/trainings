package problema1;

import java.io.File;

public class FileListFromFolder {

    public static void main(String a[]) {
        File file = new File("C:\\Users\\constantinb\\Documents\\");
        String[] fileList = file.list();
        for (int i=0;i<=fileList.length;i++) {
            System.out.println(fileList[i]);
        }
    }
}
