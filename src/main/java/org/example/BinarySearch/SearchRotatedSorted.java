package org.example.BinarySearch;

public class SearchRotatedSorted {

    private static int findPivot(int[] arr, int n) {
        int s = 0;
        int e = n-1;

        while(s < e) {
            int m = s + (e - s) / 2;

            if(arr[m] > arr[e]) {
                s = m+1;
            }
            else {
                e = m;
            }
        }
        return s;
    }

    public static boolean binarySearch(int[] arr, int s, int e, int t) {

        while(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] == t)
                return true;
            else if(arr[m] > t)
                e = m-1;
            else
                s = m+1;
        }

        return false;
    }

    public static void function(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr, arr.length);
        System.out.print(pivot + " : ");
        if(binarySearch(arr, 0, pivot-1, x)){
            System.out.println("ture");
        }
        else {
            System.out.print(binarySearch(arr, pivot, n-1, x));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5}, 1);
        function(new int[] {2,3,4,5,1}, 9);
        function(new int[] {3,4,5,1,2}, 1);
        function(new int[] {4,5,1,2,3}, 8);
        function(new int[] {5,1,2,3,4}, 1);
    }
}
