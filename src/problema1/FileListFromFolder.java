package problema1;

import java.io.File;

public class FileListFromFolder {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\constantinb\\Document\\");

        if(file.exists()){
            System.out.println(file + " exista");

        }
        else System.out.println("nu exista");
    }
}
