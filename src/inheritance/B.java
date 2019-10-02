package inheritance;

class B extends A {
    static
    {
        i++;
    }

    static
    {
        --j;
    }


    public static void main(String[] args)

    {
        System.out.println(i);

        System.out.println(j);
    }
}