package org.example.LinkedList.Medium;

import java.util.List;

public class DetectLoop {
    static void detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                System.out.println("Loop detected");
                return;
            }
        }
        System.out.println("Loop not detected");
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(3,2,0,-4).forEach(n -> l1.insertAtTail(n));
        // l1.tail.next = l1.head.next;


        detectLoop(l1.head);

    }
}
