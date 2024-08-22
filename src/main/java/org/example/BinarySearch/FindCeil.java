package org.example.BinarySearch;

public class FindCeil {
    public static int findCeil(int arr[], int s, int e, int x) {
        int ans = -1;
        while(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] >= x) {
                ans = m;
                e = m-1;
            }
            else {
                s = m+1;
            }
        }
        return ans;
    }

    public static void function(int[] arr, int x) {
        System.out.println(findCeil(arr, 0, arr.length-1, x));
    }

    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5,6,7}, 3);
        function(new int[] {11,22,33,44,55}, 23);
    }
}
