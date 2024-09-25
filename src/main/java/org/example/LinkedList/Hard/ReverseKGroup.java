package org.example.LinkedList.Hard;

import org.example.LinkedList.Hard.LinkedList;

import java.util.List;

public class ReverseKGroup {
    private static Node reverseKGroup(Node head, int k) {
        Node prev = null;
        Node temp = head;
        Node next = null;

        int count = 0;
        while (temp != null && count < k) {
            next = temp.next;
            temp.next = prev;
            prev = temp;

            temp = next;
            count++;
        }

        if (count == k)
            head.next = reverseKGroup(next, k);
        else
            prev = head;

        return prev;
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(1,2,3,4,5).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();
        l1.head = reverseKGroup(l1.head, 3);
        l1.printNodes();
    }
}
