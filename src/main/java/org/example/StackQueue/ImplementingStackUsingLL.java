package org.example.StackQueue;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class StackLL {
    Node top;
    StackLL() {
        this.top = null;
    }
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack");
    }
    void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped from stack: " + top.data);
        top = top.next;
    }
    void peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element is: " + top.data);
    }
    boolean isEmpty() {
        return top == null;
    }
    void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class ImplementingStackUsingLL {
    public static void main(String[] args) {
        StackLL stack = new StackLL();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();

        stack.peek();

        stack.pop();
        stack.pop();

        stack.display();

        stack.peek();

        stack.pop();
        stack.pop();

        stack.isEmpty();
    }
}