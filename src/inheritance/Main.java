package inheritance;

public class Main {
    public static void main(String[] args) {
        String classes[] = {"mate", "engleza"};
        Teacher t = new Teacher("ion", classes);

       /* t.setNume("Andrei");


        t.setClasses(classes);
        t.walk();
        Person p =new Teacher();
        p.walk();
         p =new Student1();
        p.walk();*/
        Student1 s = new Student1();
        Person p = new Person("Andrei");
        System.out.println(p.getNume());
        System.out.println(t.getNume());

        printTeach(t);


        String c[] = {"m"};
        Teacher TT = new Teacher("ghe", classes);
        printTeach(TT);
    }
    private static void printTeach(Teacher t) {
        for(int i=0;i<t.classes.length;i++){
            if(t.classes[i]!=null) {
                System.out.println(t.getNume()+" " +t.getClasses()[i]);
            }
        }
    }
}

