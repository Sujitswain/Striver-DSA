package org.example.DoublyLL;

import java.util.List;

public class DeleteOccurence {
    private static Node removeOccurences(Node head, int k) {
        Node temp = head;

        while(temp != null) {
            if(temp.data == k) {
                if(temp.prev == null) {             // whether it is a head node
                    head = temp.next;               // move forward
                    if(head != null)                // see whether it has more than one node
                        head.prev = null;           // make that node prev to null
                }
                else
                    temp.prev.next = temp.next;

                if(temp.next != null)
                    temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        DoublyLL d1 = new DoublyLL();
        List.of(2,2,10,8,4,2,5,2).forEach(n -> d1.InsertAtTail(n));

        d1.PrintNodes();
        d1.head = removeOccurences(d1.head, 2);
        d1.PrintNodes();
    }
}
