package org.example.Bitmanipulation;

public class OddNumTime {
    public static void main(String[] args) {
        function(new int[] {2, 2, 1});
        function(new int[] {4, 1, 2, 1, 2});
    }
    private static void function(int[] arr) {
        int xor = 0;
        for(int i=0; i<arr.length; i++) {
            xor ^= arr[i];
        }
        System.out.println(xor);
    }
}
