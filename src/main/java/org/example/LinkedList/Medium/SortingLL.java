package org.example.LinkedList.Medium;

import java.util.List;

public class SortingLL {
    private static void sortLL(Node head) {
        Node ptr1 = head;

        while(ptr1 != null) {
            Node ptr2 = ptr1.next;
            boolean swap = false;
            while(ptr2 != null) {
                if(ptr1.data > ptr2.data) {
                    swap = true;
                    int temp = ptr1.data;
                    ptr1.data = ptr2.data;
                    ptr2.data = temp;
                }
                ptr2 = ptr2.next;
            }
            if(!swap)
                return;

            ptr1 = ptr1.next;
        }
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(50,30,40,10,20).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();

        sortLL(l1.head);

        l1.printNodes();
    }
}
