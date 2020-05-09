package agentieDeTurism;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        File file2 = new File("C:\\Users\\constantinb\\Documents\\users.txt");
        System.out.println("Introduceti user");
        Scanner u = new Scanner(System.in);
        System.out.println("introdu username-ul");
        String username = u.nextLine();
        System.out.println("introdu parola");
        String password = u.nextLine();
        boolean b = true;
        boolean c=true;
        boolean d=true;
        String rol=null;
        while (true) {
            try {
                Scanner sc = new Scanner(file2);

                while (sc.hasNextLine()) {
                    if (username.equals(sc.nextLine())) {
                        if (password.equals(sc.nextLine())) {
                            rol = sc.nextLine();
                            System.out.println("rol " + rol);
                            b = false;
                            break;
                        } else {
                            continue;
                        }

                    }
                }
            if (b == false) {
                System.out.println("userul exista");
                break;
            } else System.out.println("userul nu exista");
            break;
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        }
        if(rol.equals("admin")){
            System.out.println("modifica");
        }else{
            if(rol.equals("client")){
                System.out.println("sortare si afisare totala");
            }
        }
    }
}
