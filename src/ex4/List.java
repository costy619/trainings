package ex4;

import java.util.ArrayList;

public interface List<T> {
    void add(T value) ;
    int get(int index);
    void put(int index, T value);
    int length();
    boolean contains(int value);
    void addAll(List<T> other);

}
