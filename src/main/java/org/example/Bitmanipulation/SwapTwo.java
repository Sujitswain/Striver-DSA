package org.example.Bitmanipulation;

public class SwapTwo {
    public static void main(String[] args) {
        int a = 4;
        int b = 23;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " : " + b);
    }
}
