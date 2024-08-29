package org.example.Arrays.Easy;

import java.util.Arrays;

public class FourSumProblem {
    public static void main(String[] args) {
        function(new int[] {1,0,-1,0,-2,2}, 0);
        function(new int[] {4,3,3,4,4,2,1,2,1,1}, 9);
    }
    private static void function(int[] arr, int t) {
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            if(i != 0 && arr[i-1] == arr[i])
                continue;
            for(int j=i+1; j<n; j++) {
                if(j != i+1 && arr[j-1] == arr[j])
                    continue;

                int k = j+1;
                int l = n-1;
                while(k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum > t) {
                        l--;
                    }
                    else if(sum < t) {
                        k++;
                    }
                    else {
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]+" "+arr[l]);
                        k++;
                        l--;

                        while(k < n && arr[k-1] == arr[k])
                            k++;

                        while(l >=0 && arr[l] == arr[l+1])
                            l--;
                    }
                }
            }
        }
    }
}
