package org.example.Arrays.Easy;

import java.util.Arrays;

public class ThreeSumProblem {
    public static void main(String[] args) {
        function(new int[] {-1,0,1,2,-1,-4});
        function(new int[] {0,1,1});
        function(new int[] {0,0,0});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            if(i != 0 && arr[i-1] == arr[i])
                continue;

            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum > 0) {
                    k--;
                }
                else if(sum < 0) {
                    j++;
                }
                else {
                    System.out.println(arr[i]+" "+arr[j]+" "+ arr[k]);
                    j++;
                    k--;

                    while(j < n && arr[j-1] == arr[j])
                        j++;

                    while(k >=0 && arr[k] == arr[k+1])
                        k--;
                }
            }
        }
    }
}
