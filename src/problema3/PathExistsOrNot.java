package problema3;

import java.io.File;

public class PathExistsOrNot {



    public static void main(String[] args) {
            File file = new File("C:\\Users\\constantinb\\Documents\\");
        String[] fileList = file.list();
            for (int i=0;i<=fileList.length;i++) {
                System.out.println(fileList[i]);
            }
        }
    }

