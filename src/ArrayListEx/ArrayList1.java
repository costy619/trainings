package ArrayListEx;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> given_text_lines = new ArrayList<String>();
        boolean user_wants_to_type_more = true;
        Scanner keyboard = new Scanner(System.in);
        while (user_wants_to_type_more == true) {
            String text_line_from_user = keyboard.nextLine();
            if (text_line_from_user.length() > 0 && text_line_from_user.charAt(0) == '.') {
                user_wants_to_type_more = false;
            } else {
                given_text_lines.add(text_line_from_user);
            }
        }
        System.out.println(given_text_lines);
    }
}
