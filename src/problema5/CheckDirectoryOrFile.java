package problema5;

import java.io.File;

public class CheckDirectoryOrFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\constantinb\\Documents");

if(file.isDirectory()) {
    System.out.println("is a directory");
}
if(file.isFile())
{
    System.out.println("is file");}


}
}
