package LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*LL list = new LL();
        list.insertionFirst(3);
        list.insertionFirst(5);
        list.insertionFirst(7);
        list.insertionFirst(5);
        list.insertionFirst(12);
        list.insertLast(54);
        list.display();
        list.insert(100,3);
        list.display();
        list.deleteFirst();
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(3));
        list.display();*/


        DLL list = new DLL();
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(5);
        list.insertFirst(12);
        list.insertLast(99);
        list.display();
    }

}


