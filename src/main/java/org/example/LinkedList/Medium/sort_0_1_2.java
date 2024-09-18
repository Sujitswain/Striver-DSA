package org.example.LinkedList.Medium;

import java.util.List;

public class sort_0_1_2 {
    private static Node sort012ByChangingLinks(Node head) {
        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node twoHead = new Node(0);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;
        while (temp != null) {
            switch (temp.data) {
                case 0 -> {
                    zero.next = temp;
                    zero = zero.next;
                }
                case 1 -> {
                    one.next = temp;
                    one = one.next;
                }
                case 2 -> {
                    two.next = temp;
                    two = two.next;
                }
            }
            temp = temp.next;
        }


        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(1, 2, 2, 1, 2, 0, 2, 2).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();

        l1.head = sort012ByChangingLinks(l1.head);

        l1.printNodes();
    }
}
