package org.example.Arrays.Medium;

public class MaxSubArraySum {
    public static void main(String[] args) {
        function(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    }
    private static void function(int[] arr) {
        kadanesAlgo(arr);
    }
    private static void kadanesAlgo(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if(sum < 0)
                sum = 0;
        }
        System.out.println("Maximum sum: " + max);
    }
}
