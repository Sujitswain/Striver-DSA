package org.example.LinkedList.Hard;

import java.util.List;

public class RotateList {
    private static int findLength(Node head) {
        Node temp = head;
        int count = 0;

        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static Node reverseKNode(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        int c = 0;

        System.out.println(head.data + " " + k);
        while(curr != null && c < k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            c++;
        }

        head.next = reverse(next);

        return prev;
    }
    private static Node rotate(Node head, int k) {

        // reverse 1
        head = reverse(head);

        // reverse 2
        head = reverseKNode(head, k);
        return head;
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(1,2,3,4,5).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();
        int n = findLength(l1.head);
        int k = 5;
        k = k % n;

        if(k != 0)
            l1.head = rotate(l1.head, k);

        l1.printNodes();
    }
}
