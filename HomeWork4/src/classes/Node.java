package classes;

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> prev;

    public Node(Node<E> prev, E element, Node<E> next){
        this.element = element;
        this.next = next;
        this.prev = prev;
        
    }
    // Геттеры и Сеттеры для класса Node
    protected Node<E> getPrev(){
        return this.prev;
    }
    protected void setPrev(Node<E> prev){
        this.prev = prev;
    }
    protected E getEl (){
        return this.element;
    }
    protected void setEl (E el){
        this.element = el;
    }
    protected Node<E> getNext() {
        return this.next;
    }
    protected void setNext(Node<E> next){
        this.next = next;
    } 
}
