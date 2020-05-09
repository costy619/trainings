package tema3ex1;

public class MainEx1 {
    public static void main(String[] args) {


        Complex c1 = new Complex(5.5, 4);
        Complex c2 = new Complex(1.2, 3.5);
        c1.add(c2);
        c1.negate();
        c2.multiply(c1);
        if(c1.equals(c2)==true){
            System.out.println("sunt egale");
        }else {System.out.println("nu sunt egale");
        }
        System.out.println(c1.toString());
        System.out.println( Complex.create(3,8));
    }
}