package org.example.Arrays.Easy;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        function(new int[] {2,5,1,3,0});
    }
    private static void function(int[] arr) {
        System.out.println(Arrays.stream(arr).max());
    }
}
