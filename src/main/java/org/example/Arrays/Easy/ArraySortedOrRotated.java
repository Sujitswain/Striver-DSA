package org.example.Arrays.Easy;

public class ArraySortedOrRotated {
    public static void main(String[] args) {
        function(new int[] {3,4,5,1,2});
        function(new int[] {2,1,3,4});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int count = arr[0] < arr[n-1] ? 1 : 0;
        for(int i=1; i<n; i++) {
            if(arr[i-1] > arr[i])
                count++;

            if(count > 1) {
                System.out.println("Not sorted");
                return;
            }
        }
        System.out.println("Sotred");
    }
}
