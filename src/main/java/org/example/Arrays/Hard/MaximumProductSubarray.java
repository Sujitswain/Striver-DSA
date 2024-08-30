package org.example.Arrays.Hard;

/*
Example 1:
Input:

 Nums = [1,2,3,4,5,0]
Output:

 120
Explanation:

 In the given array, we can see 1×2×3×4×5 gives maximum product value.


Example 2:
Input:
 Nums = [1,2,-3,0,-4,-5]
Output:

 20
Explanation:

 In the given array, we can see (-4)×(-5) gives maximum product value.
*/

public class MaximumProductSubarray {
    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5,0});
        function(new int[] {1,2,-3,0,-4,-5});
    }
    private static void function(int[] arr) {
        optimalSolution(arr);
        KadaneAlgorithm(arr);
    }
    private static void KadaneAlgorithm(int[] arr) {
        int n = arr.length;
        int prod1=0, prod2=0, max=0;
        prod1 = prod2 = max = arr[0];

        for(int i=1; i<n; i++) {
            int temp = Math.max(arr[i], Math.max(prod1*arr[i], prod2*arr[i]));
            prod1 = Math.min(arr[i], Math.min(prod1*arr[i], prod2*arr[i]));
            prod2 = temp;

            max = Math.max(max, prod2);
        }
        System.out.println(max);
    }
    private static void optimalSolution(int[] arr) {
        int n = arr.length;
        int max = 0;

        int prefix = 1;
        int suffix = 1;
        for(int i=0; i<n; i++) {
            prefix *= arr[i];
            suffix *= arr[n-i-1];

            max = Math.max(max, Math.max(prefix, suffix));

            if(prefix == 0)
                prefix = 1;

            if(suffix == 0)
                suffix = 1;
        }
        System.out.println(max);
    }

}
