package problema4;

import java.io.File;
import java.io.FilenameFilter;
import java.security.Permission;

public class FileHasReadOrWritePermision {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\constantinb\\desktop\\java.txt");
        if (file.exists()) {
            if (file.canWrite()) {

                System.out.println("Writable: ");
            }
            else {
                System.out.println("Not Writable");
            }
            if (file.canRead()) {
                System.out.println("Readable: ");
            } else System.out.println("Not Readable: ");

        }

    }
}
