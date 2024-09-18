package org.example.LinkedList.Medium;

import java.util.List;

public class MiddleOfALinkedList {
    static void findMiddleOfLL(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle = " + slow.data);
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(10,20,30,40,50).forEach(n -> l1.insertAtTail(n));

        l1.printNodes();

        findMiddleOfLL(l1.head);

        LinkedList l2 = new LinkedList();
        List.of(10,20,30,40,50,60).forEach(n -> l2.insertAtTail(n));

        l2.printNodes();

        findMiddleOfLL(l2.head);
    }
}
