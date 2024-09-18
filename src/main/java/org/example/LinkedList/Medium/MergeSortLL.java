package org.example.LinkedList.Medium;

import java.util.List;

public class MergeSortLL {
    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static Node merge(Node left, Node right) {
        LinkedList mergedList = new LinkedList();

        while(left != null && right != null) {
            if(left.data < right.data) {
                mergedList.insertAtTail(left.data);
                left = left.next;
            }
            else {
                mergedList.insertAtTail(right.data);
                right = right.next;
            }
        }

        while(left != null) {
            mergedList.insertAtTail(left.data);
            left = left.next;
        }

        while(right != null) {
            mergedList.insertAtTail(right.data);
            right = right.next;
        }

        return mergedList.head;
    }
    private static Node mergeSort(Node head) {
        if(head == null || head.next == null)
            return head;

        Node mid = findMid(head);
        Node left = head;

        Node right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List.of(3,4,2,5,63,6,8,346,8,4,1,111).forEach(n -> l1.insertAtTail(n));

        l1.printNodes();
        l1.head = mergeSort(l1.head);
        l1.printNodes();
    }
}
