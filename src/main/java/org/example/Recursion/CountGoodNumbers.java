package org.example.Recursion;

public class CountGoodNumbers {
    public static void main(String[] args) {
        function(1);
        function(4);
        function(50);
    }
    private static void function(int n) {
        iterativeFunction(n);
    }
    private static void iterativeFunction(int n) {
        long res = 1;
        for(int i=0; i<n; i++) {
            res = ((i&1) == 1) ? 4 * res : 5 * res;
        }
        System.out.println(res);
    }
}
