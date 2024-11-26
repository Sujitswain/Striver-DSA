package org.example.StackQueue;

class QueueLL {
    Node rear = null;
    Node front = null;
    void push(int data) {
        Node newNode = new Node(data);
        if (rear == null)
            rear = front = newNode;
        else {
            rear.next = newNode;
            rear = newNode;
        }
        display();
    }
    void pop() {
        if (front == null) {
            System.out.println("Queue Empty");
            return;
        }
        if (front == rear)
            front = rear = null;
        else
            front = front.next;

        display();
    }
    void display() {
        if (front == null) {
            System.out.println("Queue Empty");
            return;
        }

        Node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ImplQueueUsingLL {
    public static void main(String[] args) {
        QueueLL queue = new QueueLL();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        queue.pop();
        queue.pop();

        queue.push(40);
        queue.push(50);
        queue.pop();
        queue.pop();
        queue.pop();
    }
}
