package org.example.Arrays.Medium;

public class MajorityElement {
    public static void main(String[] args) {
        function(new int[] {3,2,3});
        function(new int[] {2,2,1,1,1,2,2});
    }
    private static void function(int[] arr) {
        optimalSolution(arr, arr.length);
    }
    private static void optimalSolution(int[] arr, int n) {
        int count = 1;
        int num = arr[0];

        for(int i=1; i<n; i++) {
            if(num == arr[i])
                count++;
            else {
                count--;
                if(count == 0) {
                    count = 1;
                    num = arr[i];
                }
            }
        }
        System.out.println(num);
    }
}
