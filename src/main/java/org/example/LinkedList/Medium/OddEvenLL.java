package org.example.LinkedList.Medium;

import java.util.List;

public class OddEvenLL {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(1,2,3,4,5,6,7).forEach(n -> l1.insertAtTail(n));

        // odd
        LinkedList odd = new LinkedList();
        // even
        LinkedList even = new LinkedList();

        Node temp = l1.head;
        boolean swap = true;
        while(temp != null) {
            if(swap) {
                if (odd.head == null) {
                    odd.head = odd.tail = new Node(temp.data);
                } else {
                    odd.tail.next = new Node(temp.data);
                    odd.tail = odd.tail.next;
                }
            }
            else {
                if (even.head == null) {
                    even.head = even.tail = new Node(temp.data);
                } else {
                    even.tail.next = new Node(temp.data);
                    even.tail = even.tail.next;
                }
            }
            temp = temp.next;
            swap = !swap;
        }
        odd.printNodes();
        even.printNodes();
    }
}
