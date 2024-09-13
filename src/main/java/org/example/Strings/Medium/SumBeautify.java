package org.example.Strings.Medium;

import java.util.Arrays;

public class SumBeautify {
    public static void main(String[] args) {
        function("aabcb");
        function("aabcbaa");
    }
    private static void function(String str) {
        int n = str.length();
        int ans = 0;
        for(int i=0; i<n; i++) {
            int[] arr = new int[26];
            for(int j=i; j<n; j++) {
                char ch = str.charAt(j);
                arr[ch - 97]++;
                int min = Arrays.stream(arr).filter(x -> x > 0).min().orElse(0);
                int max = Arrays.stream(arr).filter(x -> x > 0).max().orElse(0);
                ans += max - min;
            }
        }
        System.out.println("Answer: " + ans);
    }
}
