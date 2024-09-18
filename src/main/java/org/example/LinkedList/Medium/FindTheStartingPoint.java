package org.example.LinkedList.Medium;

import java.util.List;

public class FindTheStartingPoint {
    private static void findTheStartingPoint(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)
                break;
        }
        System.out.println(slow.data);

        slow = head;
        Node intersection = fast;

        while(slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }
        System.out.println(slow.data);
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(3, 2, 0, -4).forEach(n -> l1.insertAtTail(n));
        l1.tail.next = l1.head.next;

        findTheStartingPoint(l1.head);
    }
}
