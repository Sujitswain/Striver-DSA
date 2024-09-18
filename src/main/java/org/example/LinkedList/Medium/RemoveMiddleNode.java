package org.example.LinkedList.Medium;

import java.util.List;

public class RemoveMiddleNode {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(1,2,3,4,5,6).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();

        Node slow = l1.head;
        Node fast = l1.head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        l1.printNodes();
    }
}
