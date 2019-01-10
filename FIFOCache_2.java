package a;

public class FIFOCache_2 {

    public static void main(String args[]) {
        FIFOCache_2 Q = new FIFOCache_2(10);
        Q.put("aa");
        Q.put("bb");
        System.out.println(Q.get());
        Q.put("cc");
        System.out.println(Q.get());
        System.out.println(Q.get());
    }
    
    private class Node {
          Object item; 
        Node next;
            
          Node ( Object item ) {
               this.item = item; 
            this.next = null;
          }
    }
    
    private Node head;
    private Node tail;
    
    FIFOCache_2 ( Object max ) { 
        head = null; 
        tail = null; 
    }
    
    boolean isEmpty() { 
        return ( head ==null ); 
    } 
    
    void put ( Object item ) {
          Node t = tail;
          tail = new Node(item);
          if ( isEmpty() )
              head = tail;
          else t.next = tail;
     }
    
    Object get() {
          Object v = head.item;
          Node t = head.next;
          head = t;
          return v;
    }
}