package org.example.LinkedList.Medium;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    Node head = null;
    Node tail = null;
    void insertAtTail(int data) {
        Node newNode = new Node(data);
        if(tail == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    void printNodes() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        if(head != null)
            System.out.println("Head = " + this.head.data);
        if(tail != null)
            System.out.println("Tail = " + this.tail.data);
    }
}
