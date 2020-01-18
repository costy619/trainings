package geometric.problem;

public class MainEX2 {
    public static void main(String args []) {
        MyArraylist<Integer> MyList = new MyArraylist();
//        int indexul=5;//daca il scoti din comentariu arunca exceptie
//        getIndex(MyList, indexul);//daca il scoti din comentariu arunca exceptie
        MyList.put(5,123);
        int indexul=5;
        getIndex(MyList, indexul);//am pus 13 elemente
        CreareMyList(MyList);
        System.out.println("List size: " + MyList.length());//nu poate fi lungimea egala nu marul de elemente introduse deoarece ai spus ca lungimea o dam noi la inceput
        int indexulValoriiCautate = 4;
        cautareDupaIndex(MyList, indexulValoriiCautate);
        MyArraylist MyList1 = new MyArraylist();
        CreareMyList1(MyList1);
        MyList.addAll(MyList1);
        MyList.add(55);
        MyList.add(66);
        for(int i=0;i<MyList.length();i++){
            System.out.println(MyList.get(i));
        }
        indexulValoriiCautate = 2;
        cautareDupaIndex(MyList, indexulValoriiCautate);
    }

    private static void cautareDupaIndex(MyArraylist<Integer> myList, int indexulValoriiCautate) {
        if (myList.contains(indexulValoriiCautate) == true) {
            System.out.println("valoarea " + indexulValoriiCautate + " este in lista ");
        }
    }

    private static void CreareMyList1(MyArraylist myList1) {
        myList1.put(0,999);
        myList1.put(1,99);
        myList1.put(17,77);
        myList1.put(77,88);
    }

    private static void CreareMyList(MyArraylist<Integer> MyList) {
        MyList.put(1, 6);
        MyList.put(2, 6);
        MyList.put(3, 6);
        MyList.put(4, 6);
        MyList.put(6, 6);
        MyList.put(7, 6);
        MyList.put(9, 6);
        MyList.put(10, 6);
        MyList.put(11, 4);
        MyList.put(12, 2);
        MyList.put(14, 1);
        MyList.put(16, 8);
    }

    private static void getIndex(MyArraylist<Integer> mal, int indexul) {

        System.out.println("valoarea de la indexul "+indexul+" este " +mal.get(indexul));
        String s="Index:"+indexul+", Size:"+mal.get(indexul);
        if(mal.get(indexul)==0){
            throw new IndexOutOfBoundsException(s);
        }
    }
}
