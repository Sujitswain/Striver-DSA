package org.example.Arrays.Easy;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        int max = arr[0];
        int smax = -1;

        for(int i=1; i<arr.length; i++) {
            if(max < arr[i]) {
                smax = max;
                max = arr[i];
            }

            if(smax < arr[i] && arr[i] != max)
                smax = arr[i];
        }
        System.out.println(smax);
    }
}
