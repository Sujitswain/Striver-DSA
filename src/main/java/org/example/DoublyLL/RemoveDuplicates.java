package org.example.DoublyLL;

import java.util.List;

public class RemoveDuplicates {
    private static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {

                Node duplicate = temp.next;
                temp.next = duplicate.next;

                if (duplicate.next != null)
                    duplicate.next.prev = temp;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        DoublyLL d1 = new DoublyLL();
        List.of(1,1,1,2,3,4).forEach(n -> d1.InsertAtTail(n));
        d1.PrintNodes();
        d1.head = removeDuplicates(d1.head);
        d1.PrintNodes();
    }
}
