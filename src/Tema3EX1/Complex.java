package Tema3EX1;

public class Complex implements ComplexNumber {
    double real, img;
    Complex(double r, double i){
        this.real = r;
        this.img = i;
    }

    @Override
    public Complex add(Complex number) {
        this.real=this.real+number.real;
        this.img=this.img+number.img;
        return Complex.this;
    }

    @Override
    public Complex negate() {
        this.real=-this.real;
        this.img=-this.img;
        return Complex.this;
    }

    @Override
    public Complex multiply(Complex number) {
        number.real=this.real;
        number.img=this.img;
        return number;
    }

    @Override
    public Boolean equals(Complex number) {
        if(this.real==number.real&&this.img==number.img){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s=this.real+" + "+this.img+"i";
        return s;
    }
   public static Complex create(double realPart, double imaginaryPart){
        Complex c=new Complex(realPart,imaginaryPart);
        return c;
   }
}
