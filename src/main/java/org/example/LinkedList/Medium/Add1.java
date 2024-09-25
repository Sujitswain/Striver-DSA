package org.example.LinkedList.Medium;

import java.util.List;

public class Add1 {
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
    private static void addOneInLL(Node head) {
        int carry = 1;
        Node temp = head;

        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            if (carry == 0)
                return;

            temp = temp.next;
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(9).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();

        Node temp = l1.head;
        l1.head = reverse(l1.head);
        l1.tail = temp;

        addOneInLL(l1.head);
        temp = l1.head;
        l1.head = reverse(l1.head);
        l1.tail = temp;
        l1.printNodes();
    }
}
