package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
 * Output:
 * 3
 * Explanation:
 * {5, 2, 3}, {2, 8}, {10} are possible subsets.
 */

public class PerfectSumProblem {
    public static void main(String[] args) {
        function(new int[] {5,2, 3, 10, 6, 8}, 10);
    }
    private static void function(int[] arr, int sum) {
        int n = arr.length;
        iterativeSolution(arr, n, sum);
        findSubsets(arr, n-1, sum, new ArrayList<>());
    }
    public static void findSubsets(int[] arr, int index, int target, List<Integer> subset) {
        if (target == 0) {
            System.out.println(subset);
            return;
        }

        if (index >= arr.length || target < 0)
            return;

        subset.add(arr[index]);
        findSubsets(arr, index + 1, target - arr[index], subset);

        subset.remove(subset.size() - 1);
        findSubsets(arr, index + 1, target, subset);
    }
    private static void iterativeSolution(int[] arr, int n, int sum) {
        int totalSubsets = 1 << n;
        int count = 0;

        for (int i = 0; i < totalSubsets; i++) {
            int subsetSum = 0;
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                    subsetSum += arr[j];
                }
            }
            if (subsetSum == sum) {
                count++;
                System.out.println("Subset: " + subset);
            }
        }
        System.out.println(count);
    }
}
