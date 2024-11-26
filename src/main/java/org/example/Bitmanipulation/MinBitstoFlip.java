package org.example.Bitmanipulation;

public class MinBitstoFlip {
    public static void main(String[] args) {
        function(10, 7);
    }

    private static void function(int n1, int n2) {
        System.out.println(Integer.toBinaryString(n1));
        System.out.println(Integer.toBinaryString(n2));
        System.out.println(Integer.toBinaryString(n1 ^ n2));

        int temp = n1 ^ n2;
        int count = 0;

        while(temp != 0) {
            count += temp & 1;
            temp = temp >> 1;
        }
        System.out.println(count);
    }
}
