package tema3ex1;

public interface ComplexNumber {
    Complex add(Complex number);//adds this and number and returns a new Complex instance
    Complex negate();// returns a new Complex number representing the -this
    Complex multiply(Complex number);// returns a new complex number that is equal to this * number
    Boolean equals(Complex number);
    String toString();// should return strings such as “3 + 4i”

}
