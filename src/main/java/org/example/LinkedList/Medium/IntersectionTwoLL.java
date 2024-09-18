package org.example.LinkedList.Medium;

import java.util.List;

public class IntersectionTwoLL {
    public static void intersectionPoint(Node n1, Node n2) {
        Node temp1 = n1;
        Node temp2 = n2;

        while(temp1 != temp2) {
            temp1 = temp1 != null ? temp1.next : n2 ;
            temp2 = temp2 != null ? temp2.next : n1 ;
        }
        System.out.println(temp1.data);
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(4,1,8,4,5).forEach(n -> l1.insertAtTail(n));

        LinkedList l2 = new LinkedList();
        List.of(5,6,1).forEach(n -> l2.insertAtTail(n));

        l2.tail.next = l1.head.next.next;
        intersectionPoint(l1.head, l2.head);
    }
}
