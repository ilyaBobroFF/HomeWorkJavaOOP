package interfaces;

public interface GBLinked<E> {
    
    boolean addFirst(E e);
    boolean addLast(E e);
    int size();
    E getByIndex(int index);
}
