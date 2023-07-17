
import linkedListSelf.GBLinkedList;


public class Main {
    public static void main(String[] args) {
        GBLinkedList<Integer> expierence = new GBLinkedList<>();
        expierence.addFirst(111);
        
        expierence.addLast(222);
        
        expierence.addFirst(333);
        
        
        System.out.println(expierence.size());
        System.out.println(expierence);
    }


    
    
}
