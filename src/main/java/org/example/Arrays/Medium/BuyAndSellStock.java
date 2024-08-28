package org.example.Arrays.Medium;

public class BuyAndSellStock {
    public static void main(String[] args) {
        function(new int[] {7,1,5,3,6,4});
        function(new int[] {7,6,4,3,1});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        int max = 0;
        for(int i=1; i<n; i++) {
            if(min > arr[i])
                min = arr[i];
            else {
                max = Math.max(max, arr[i]-min);
            }
        }
        System.out.println("Max Profit: " + max);
    }
}
