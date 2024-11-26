package org.example.StackQueue;

class Queue {
    int size, front, rear;
    int[] arr;
    Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.rear = -1;
        this.front = -1;
    }
    void push(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else
            rear = (rear + 1) % size;

        arr[rear] = data;
        display();
    }
    void pop() {
        if(front == -1) {
            System.out.println("Empty Queue");
            return;
        }
        else if(front == rear) {
            front = -1;
            rear = -1;
        }
        else
            front = (front + 1) % size;

        display();
    }
    void display() {
        if (front == -1) {
            System.out.println("Empty Queue");
            return;
        }
        System.out.print("QUEUE ELEMENTS: ");
        int i = front;
        while (i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println(arr[rear]);  // we are printing this at last because
                                        // we are printing a circular pattern.
    }
}

public class ImplementingQueueUsingArrays {
    public static void main(String[] args) {
        Queue q = new Queue(5);


        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);

        q.push(60);

        q.pop();
        q.pop();

        q.push(60);
        q.push(70);

        q.pop();
        q.pop();
        q.pop();
        q.pop();
    }
}
