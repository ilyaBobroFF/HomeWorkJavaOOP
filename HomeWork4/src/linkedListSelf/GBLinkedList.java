package linkedListSelf;


import linkedListInterfaces.GBLinked;


public class GBLinkedList<E> 
    implements GBLinked<E> {
    int size;
    private Node<E> firstEl;
    private Node<E> lastEl;


    public GBLinkedList() {
        lastEl = new Node<E>(firstEl, null, null);
        firstEl = new Node<E>(null, null, lastEl);
    }
   
    
    
    @Override
    public boolean addFirst(E el) {
        Node<E> temp = firstEl;
        temp.setEl(el);
        temp.setPrev(firstEl);
        firstEl = new Node<E>(null, null, temp);
        size++;
        return true;
    }
    @Override
    public boolean addLast(E el) {
        Node<E> temp = lastEl;
        temp.setEl(el);
        temp.setNext(lastEl);
        lastEl = new Node<E>(temp, null, null);
        size++;
        return true;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public E getByIndex(int index) {
        Node<E> temp = firstEl.getNext();
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp.getEl();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size - 1; i++){
            result.append(this.getByIndex(i)+"\n");
        }
        result.append(this.getByIndex(size-1));
        return result.toString();
    }
    
    
}
