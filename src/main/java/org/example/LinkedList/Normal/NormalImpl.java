package org.example.LinkedList.Normal;

import java.util.List;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;
    void InsertAtHead(int data) {
        Node newNode = new Node(data);
        if(head == null)
            head = tail = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    void InsertAtPos(int pos, int data) {
        if(pos == -1) {
            System.out.println("Position Does not Exist: " + pos);
            return;
        }

        if(pos == 0) {
            InsertAtHead(data);
            return;
        }

        int c = 1;
        Node temp = head;
        while(c < pos) {
            temp = temp.next;
            c++;
            if(temp == null) {
                System.out.println("Position Crossed the boundary: " + pos);
                return;
            }
        }

        if(temp.next == null) {
            InsertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    void InsertAtTail(int data) {
        Node newNode = new Node(data);
        if(tail == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    void DeleteAtHead() {
        if(head == null)
            System.out.println("Empty List");
        else if(head.next == null)
            head = tail = null;
        else
            head = head.next;
    }
    void DeleteAtTail() {
        if(tail == null)
            System.out.println("Empty List");
        else if(head.next == null)
            head = tail = null;
        else {
            Node temp = head;
            while(temp.next.next != null)
                temp = temp.next;

            tail = temp;
            temp.next = null;
        }
    }
    void DeleteAtPos(int pos) {

        if(pos == 1) {
            DeleteAtHead();
            return;
        }

        int c = 1;
        Node prev = null;
        Node curr = head;
        while(c < pos) {
            prev = curr;
            curr = curr.next;
            c++;
            if(curr == null) {
                System.out.println("Crossed the Boundary: " + pos);
                return;
            }
        }

        if(curr.next == null) {
            prev.next = null;
            tail = prev;
            return;
        }

        prev.next = curr.next;
        curr.next = null;
    }
    void reverseALLIterative() {
        Node prev = null;
        Node temp = head;
        tail = head;

        while(temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;

            temp = next;
        }
        head = prev;
    }
    void reverseALLRecursive() {
        tail = head;
        // reverseALLRecursiveOne(null, head);
        head = reverseALLRecursiveTwo(head);
    }
    private Node reverseALLRecursiveTwo(Node head) {
        if(head.next == null)
            return head;

        Node nextHead = reverseALLRecursiveTwo(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }
    private void reverseALLRecursiveOne(Node prev, Node curr) {
        if(curr == null) {
            head = prev;
            return;
        }

        reverseALLRecursiveOne(curr, curr.next);
        curr.next = prev;
    }



    void PrintList() {
        Node temp = head;
        if(temp == null) {
            System.out.println("Empty List");
            return;
        }

        System.out.println("The Nodes are: ");
        while(temp != null) {
            System.out.println(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println("Head: " + head.data);
        System.out.println("Tail: " + tail.data);
    }
}

public class NormalImpl {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        // List.of(10, 20).stream().forEach(n -> l1.InsertAtHead(n));
        List.of(10, 20, 30, 40, 50).stream().forEach(n -> l1.InsertAtTail(n));
        // l1.InsertAtPos(0, 1);
        // l1.InsertAtPos(2, 2);
        // l1.PrintList();

        // l1.DeleteAtPos(1);
        // l1.DeleteAtTail();
        // l1.DeleteAtHead();

        // l1.reverseALLIterative();
        // l1.reverseALLRecursive();

        l1.PrintList();
    }
}
