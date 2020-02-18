package tema5ex3;

public class Print implements Function{

    @Override
    public int evaluate(int i) {
        System.out.println(i);
        return i;
    }
}
