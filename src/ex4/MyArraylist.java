package ex4;

public class MyArraylist<T> implements List<T> {
    private Object[] myStore;
    private Object[] myStoreBackup;
    int startSize=18;

    public MyArraylist() {
        myStore = new Object[startSize];
    }
    int actSize=startSize;
    @Override
    public void put(int index, T value) {
        try {
            try {
                if (myStore.length < index) {
                }
            } catch (Exception ArrayIndexOutOfBoundsException) {
                System.out.println("Esti la furat");
            }
            myStore[index] = value;
        } catch (Exception ArrayIndexOutOfBoundsException) {
            System.out.println("Indexul este prea mare trebuie introdus un index de maxim" + startSize);
        }
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < myStore.length - 1; i++) {
            if (myStore[i] != null && myStore[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object value) {
       if(myStore.length==startSize){
           myStoreBackup=myStore;
            myStore = new Object[myStore.length*2];
            for(int i=0;i<myStoreBackup.length;i++){
                    myStore[i] = myStoreBackup[i];
            }
        }
        if(actSize==myStore.length){
            myStoreBackup=myStore;
            myStore = new Object[myStore.length*2];
            for(int i=0;i<myStoreBackup.length;i++){
                myStore[i] = myStoreBackup[i];
            }
        }
        myStore[actSize]=value;
        actSize++;

    }

    @Override
    public int get(int index) {

        if (myStore[index] != null) {
            return (int) myStore[index];
        } else return 0;

    }

    public int length() {
        Object[] l = new Object[myStore.length];
        return l.length;
    }

    @Override
    public void addAll(List<T>other) {
        if(myStore.length==startSize){
            myStoreBackup=myStore;
            myStore = new Object[myStore.length*2];
            for(int i=0;i<myStoreBackup.length;i++){
                myStore[i] = myStoreBackup[i];
            }
        }
        if(actSize==myStore.length){
            myStoreBackup=myStore;
            myStore = new Object[myStore.length*2];
            for(int i=0;i<myStoreBackup.length;i++){
                myStore[i] = myStoreBackup[i];
            }
        }
        for(int i=0;i<other.length();i++) {
            if (other.get(i)!= 0) {
                myStore[actSize] = other.get(i);
                actSize++;
            }
        }
    }
}

