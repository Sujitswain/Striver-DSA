package org.example.StackQueue;

class Stack {
    int size;
    int top;
    int[] arr;
    Stack(int size) {
        this.top = -1;
        this.size = size;
        this.arr = new int[size];
    }

    void push(int data) {
        if(size - top > 1) {
            top++;
            arr[top] = data;
            display();
        }
        else {
            System.out.println("Stack Overflow");
        }
    }

    void pop() {
        if(top == -1) {
            System.out.println("Empty stack");
        }
        else {
            top--;
            display();
        }
    }

    void display() {
        int temp = top;
        System.out.println("STACK ELEMENTS: ");
        while (temp >= 0) {
            System.out.print(arr[temp] + " ");
            temp--;
        }
        System.out.println();
    }

    void peek() {
        if(top != -1) {
            System.out.println("Top: " + arr[top]);
        }
        else {
            System.out.println("Empty stack");
        }
    }

    void isEmpty() {
        if(top == -1) {
            System.out.println("Stack Empty: Yes");
        }
        else {
            System.out.println("Stack Empty: No");
        }
    }
}

public class ImplStackUsingArrays {
    public static void main(String[] args) {
        Stack s1 = new Stack(5);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);

        s1.pop();
        s1.peek();
        s1.pop();
        s1.peek();

    }
}
