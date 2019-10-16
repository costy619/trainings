package inheritance;

public class MainCar {
    public static void main(String[] args) {
        Car myCar= new Car();
        myCar.hp=120;
        Engine mm=new Engine(4000,"mm");
        myCar.myEngine=mm;
        //String n="300";
       // myCar.setHp(Integer.parseInt(n));
        System.out.println(myCar.myEngine.CapacitateCilindrica + " " + myCar.hp);
    }
}
