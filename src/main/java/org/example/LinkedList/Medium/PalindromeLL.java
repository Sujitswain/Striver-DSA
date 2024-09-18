package org.example.LinkedList.Medium;

import java.util.List;

public class PalindromeLL {
    private static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev =current;

            current = next;
        }
        head = prev;
        return head;
    }
    private static boolean isPalindromeOrNot(Node l1, Node l2) {
        while(l1 != null && l2 != null) {
            if(l1.data == l2.data) {
                l1 = l1.next;
                l2 = l2.next;
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(1,2,3,2,1).forEach(n -> l1.insertAtTail(n));
        List.of(1,0,1).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();

        Node middle = findMiddle(l1.head);
        middle.next = reverse(middle.next);
        Node nextLL = middle.next;

        l1.printNodes();

        middle.next = null;
        boolean isPalingOrNot = isPalindromeOrNot(l1.head, nextLL);
        System.out.println("isPalindromeOrNot: " + isPalingOrNot);
    }
}
