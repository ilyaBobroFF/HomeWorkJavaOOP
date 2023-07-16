
import classes.GBLinkedList;


public class Main {
    public static void main(String[] args) {
        GBLinkedList<Integer> expierence = new GBLinkedList<>();
        expierence.addFirst(111);
        
        expierence.addLast(222);
        
        expierence.addFirst(333);
        
        expierence.printLinked();
        
        System.out.println(expierence.size());
    }


    
    
}
