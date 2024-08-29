package org.example.Arrays.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        function(new int[] {1,1,0,1,1,1});
        function(new int[] {1,0,1,1,0,1});
    }

    private static void function(int[] arr) {
        int n = arr.length;
        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }
}
