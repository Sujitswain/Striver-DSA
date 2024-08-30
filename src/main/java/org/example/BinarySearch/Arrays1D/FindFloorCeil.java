package org.example.BinarySearch.Arrays1D;

public class FindFloorCeil {

    public static int findFloor(int arr[], int s, int e, int x) {
        int ans = -1;
        while(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] <= x) {
                ans = m;
                s = m+1;
            }
            else {
                e = m-1;
            }
        }
        return ans;
    }

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
        System.out.println("floor: " + findFloor(arr, 0, arr.length-1, x));
        System.out.println("ceil: " + findCeil(arr, 0, arr.length-1, x));
    }

    public static void main(String[] args) {

        /*
        * FLOOR:
        * Find the index of k such that k is == or > than x;
        *
        * CEIL:
        * Find the index of k such that k is == or < x;
        *
        * */

        function(new int[] {1,2,3,4,5,6,7}, 3);
        function(new int[] {11,22,33,44,55}, 23);
    }
}
