package org.example.LinkedList.Medium;

import java.util.List;

public class RemoveNthNode {
    private static Node RemoveNthNodeBack(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node temp2 = dummy;

        Node temp = head;
        for(int i=0; i<k; i++)
            temp = temp.next;

        while(temp != null) {
            temp2 = temp2.next;
            temp = temp.next;
        }
        temp2.next = temp2.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(10,20,30,40,50).forEach(n -> l1.insertAtTail(n));
        l1.printNodes();

        l1.head = RemoveNthNodeBack(l1.head, 2);
        l1.printNodes();
    }
}
