package org.example.Arrays.Medium;

public class SpiralRotateMatrix {
    public static void main(String[] args) {
        function(new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            });
        function(new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
            });
    }
    private static void function(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int top = 0;
        int left = 0;
        int right = col-1;
        int bottom = row-1;

        while(top <= bottom && left <= right) {
            for(int i=left; i<=right; i++)
                System.out.print(arr[top][i] + " ");
            top++;

            for(int i=top; i<=bottom; i++)
                System.out.print(arr[i][right] + " ");
            right--;

            if(top<=bottom) {
                for(int i=right; i>=left; i--)
                    System.out.print(arr[bottom][i] + " ");
                bottom--;
            }

            if(left<=right) {
                for(int i=bottom; i>=top; i--)
                    System.out.print(arr[i][left] + " ");
                left++;
            }
        }
        System.out.println();
    }
}
