package org.example.Arrays.Medium;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        function(new int[] {1,2,3,4});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];

        int i, j;

        left[0] = 1;
        right[n - 1] = 1;

        for (i = 1; i < n; i++)
            left[i] = arr[i - 1] * left[i - 1];
        System.out.println(Arrays.toString(left));
        for (j = n - 2; j >= 0; j--)
            right[j] = arr[j + 1] * right[j + 1];
        System.out.println(Arrays.toString(right));
        for (i = 0; i < n; i++)
            prod[i] = left[i] * right[i];
        System.out.println(Arrays.toString(prod));
    }
}
