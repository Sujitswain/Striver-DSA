package org.example.Arrays.Hard;

/*

Example 1:
Input:

n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]

Output:

arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:

After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:
Input:

n = 4, arr1[] = [1 3 5 7]
m = 5, arr2[] = [0 2 6 8 9]

Output:

arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:

After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
* */

import java.util.Arrays;

public class MergeSortArrayConstant {
    public static void main(String[] args) {
        function(new int[] {1,4,8,10}, new int[] {2,3,9});
        function(new int[] {1,2,3,4}, new int[] {8,9,10});
        function(new int[] {1,3,5,7}, new int[] {0,2,6,8,9});
    }
    private static void function(int[] arr1, int[] arr2) {
        // MergeMethod(arr1, arr1.length, arr2, arr2.length);
        // SortingMethod(arr1, arr1.length, arr2, arr2.length);
        ShellSortMethod(arr1, arr1.length, arr2, arr2.length);
    }
    private static void ShellSortMethod(int[] arr1, int n, int[] arr2, int m) {
        int len = n+m;
        int gap = len/2 + len%2;

        while(gap > 0) {

            int left = 0;
            int right = left+gap;

            while(right < len) {
                if(left < n && right >= n)
                    swapIfGreater(arr1, arr2, left, right-n);
                else if(left >= n)
                    swapIfGreater(arr2, arr2, left-n, right-n);
                else
                    swapIfGreater(arr1, arr1, left, right);

                left++;
                right++;
            }

            if(gap == 1)
                break;

            gap = gap/2 + gap%2;
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    private static void swapIfGreater(int[] arr1, int[] arr2, int a, int b) {
        if(arr1[a] > arr2[b]) {
            int temp = arr1[a];
            arr1[a] = arr2[b];
            arr2[b] = temp;
        }
    }
    private static void SortingMethod(int[] arr1, int n, int[] arr2, int m) {
        int i = n-1;
        int j = 0;

        while(i>=0 && j<m) {
            if(arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
                continue;
            }
            break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    private static void MergeMethod(int[] arr1, int n, int[] arr2, int m) {
        int[] res = new int[n+m];
        int i=0, j=0, k=0;

        while(i<n && j<m) {
            if(arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                i++;
            }
            else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i<n) {
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j<m) {
            res[k] = arr2[j];
            j++;
            k++;
        }

        for(i=0; i<n; i++)
            arr1[i] = res[i];

        for(j=0; j<m; j++)
            arr2[j] = res[j+n];

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
