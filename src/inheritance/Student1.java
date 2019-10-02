package inheritance;

public class Student1   extends Person{
    protected int[] note;
    protected int[] getNote(){
        return note;
    }

    public void setNote(int[] note) {
        this.note = note;
    }
    @Override
    public void walk(){
        System.out.println("Student1 is walking");
    }
    public Student1(){
        System.out.println("Student1");
    }
    public Student1(String [] classes){
        super();
        System.out.println("student is here");
    }
}
