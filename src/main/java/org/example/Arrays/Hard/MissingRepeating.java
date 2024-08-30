package org.example.Arrays.Hard;

import java.util.Arrays;

public class MissingRepeating {
    public static void main(String[] args) {
        function(new int[] {1,5,3,3,2});
        function(new int[] {5,4,3,2,5});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int repeating = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            } else {
                repeating = arr[i];
                break;
            }
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        System.out.println(repeating + " : " + missing);
    }
}
