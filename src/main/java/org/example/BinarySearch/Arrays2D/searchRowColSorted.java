package org.example.BinarySearch.Arrays2D;

public class searchRowColSorted {
    public static void main(String[] args) {
        function(new int[][] {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        }, 5);
    }
    private static void function(int[][] arr, int t) {
        int row = arr.length;
        int col = arr[0].length;

        int s = 0, e = col-1;

        while(s<row && e>=0){
            if(arr[s][e] == t) {
                System.out.println(s+" "+e);
                return;
            }
            else if(arr[s][e] > t)
                e--;
            else
                s++;
        }
        System.out.println("Not Found");
    }
}
