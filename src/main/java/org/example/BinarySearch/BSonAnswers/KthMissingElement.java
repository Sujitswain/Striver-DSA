package org.example.BinarySearch.BSonAnswers;

public class KthMissingElement {
    public static void main(String[] args) {
        function(new int[] {4,7,9,10}, 1);
        function(new int[] {2,3,4,7,11}, 5);
        function(new int[] {1,2,3,4}, 2);
    }

    private static void function(int[] arr, int k) {
        bruteForce(arr, k);
        BS(arr, k);
    }

    private static void BS(int[] arr, int k) {
        int n = arr.length;
        int s = 0, e = n-1;

        while(s <= e) {
            int m = s+(e-s)/2;
            int val = arr[m] - (m+1);
            if(val < k) {
                s = m+1;
            }
            else {
                e = m-1;
            }
        }
        System.out.println(k + e + 1);
    }

    private static void bruteForce(int[] arr, int k) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= k)
                k++;
            else
                break;
        }
        System.out.println(k);
    }
}
