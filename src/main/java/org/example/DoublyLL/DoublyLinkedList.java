package org.example.DoublyLL;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLL {
    Node head = null;
    Node tail = null;

    void InsertAtHead(int data) {
        Node newNode = new Node(data);
        if(head == null)
            head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;

            head = newNode;
        }
    }

    void InsertAtTail(int data) {
        Node newNode = new Node(data);
        if(tail == null)
            head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void reverse() {
        Node prev = null;
        Node temp = head;
        tail = head;

        while(temp != null) {
            prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;

            temp = temp.prev;
        }
        head = prev.prev;
    }

    void PrintNodes() {
        if(head == null) {
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("Head: " + head.data);
        System.out.println("Tail: " + tail.data);
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLL l1 = new DoublyLL();

        l1.InsertAtTail(40);
        l1.InsertAtTail(30);
        l1.InsertAtTail(20);
        l1.InsertAtTail(10);

        l1.PrintNodes();

        l1.reverse();

        l1.PrintNodes();
    }
}
