import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class s
{
    private static Pattern twopart = Pattern.compile("(\\d+)-(\\d+)");

    public static void checkString(String s)
    {
        Matcher m = twopart.matcher(s);
        if (m.matches()) {
            System.out.println(s + " matches; first part is " + m.group(1) +
                    ", second part is " + m.group(2) + ".");
        } else {
            System.out.println(s + " does not match.");
        }
    }

    public static void main(String[] args) {
        checkString("123-4567");
        checkString("foo-bar");
        checkString("123-");
        checkString("-4567");
        checkString("123-4567-890");
    }
}