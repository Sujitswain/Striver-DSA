package org.example.DoublyLL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairs {
    private static void findPairs(Node head, int k) {
        Node temp = head;
        Set<Integer> set = new HashSet<>();
        while(temp != null) {
            if(set.contains(k - temp.data)) {
                System.out.println(temp.data + " " + (k- temp.data));
            }
            set.add(temp.data);
            temp = temp.next;
        }
    }
    private static void findPairsSorted(Node head, Node tail, int k) {
        Node left = head;
        Node right = tail;

        while(left != null && right != null && left != right && left.prev != right) {
            int sum = left.data + right.data;
            if(sum == k) {
                System.out.println(left.data + " " + right.data);
                left = left.next;
                right = right.prev;
            }
            else if(sum < k)
                left = left.next;
            else
                right = right.prev;
        }
    }
    public static void main(String[] args) {
        DoublyLL d1 = new DoublyLL();
        List.of(1,2,4,5,6,8,9).forEach(n -> d1.InsertAtTail(n));
        d1.PrintNodes();
        findPairsSorted(d1.head, d1.tail, 7);
    }
}
