package org.example.Bitmanipulation;

public class GetSetClear {
    public static void main(String[] args) {
        function(70, 3);
    }
    private static void function(int n, int i) {
        System.out.println(n + ": " + Integer.toBinaryString(n));
        int getIthBit = (int)(n >> (i-1) & 1);
        System.out.println(getIthBit);

        int setIthBit = n | (1 << (i-1));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(1<<(i-1)));
        System.out.println(setIthBit);

        int clearIthBit = n & ~(1 << (i-1));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(~(1<<(i-1))));
        System.out.println(clearIthBit);
    }
}
