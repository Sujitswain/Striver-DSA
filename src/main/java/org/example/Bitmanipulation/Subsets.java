package org.example.Bitmanipulation;

public class Subsets {
    public static void main(String[] args) {
        function(new int[] {1,2,3});
    }
    private static void function(int[] arr) {
        int n = 1 << arr.length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<arr.length; j++) {
                if((i & (1 << j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }

    }
}
