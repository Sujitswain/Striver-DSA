package org.example.LinkedList.Medium;

import java.util.List;

public class FindLengthLoop {
    private static void findStartLoop(Node head) {

        // loop is present or not
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null) {
            System.out.println("No loop detected");
            return;
        }

        // find the starting point
        slow = head;
        Node intersection = fast;
        while(slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }

        // remove the loop
        Node starting = slow;
        Node temp = slow;
        while(temp.next != slow)
            temp = temp.next;

        temp.next = null;

        // count the nodes in loop
        int count = 0;
        while(starting != null) {
            count++;
            starting = starting.next;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(10,20,30,40,50).forEach(n -> l1.insertAtTail(n));
        l1.tail.next = l1.head.next;

        findStartLoop(l1.head);
    }
}
