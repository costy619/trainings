package teste;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        String b="aaabccddabb";
        ArrayList listaCuNumarare = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < b.length(); i++) {
            if (i < b.length() - 1 && b.charAt(i) == b.charAt(i + 1)) {
                count++;

            } else {
                listaCuNumarare.add(b.charAt(i));
                listaCuNumarare.add(count);
                count=1;
            }
        }
        System.out.println(listaCuNumarare);
    }
}


