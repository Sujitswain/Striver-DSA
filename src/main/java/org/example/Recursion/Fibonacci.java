package org.example.Recursion;

import java.util.ArrayList;

public class Fibonacci {

    public static void recursion(ArrayList<Integer> res, int n, int a, int b) {
        if(a > n)
            return;

        res.add(a);
        recursion(res, n, b, a+b);
    }
    public static void function(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        recursion(res, n, 0, 1);
        System.out.println(res);
    }
    public static void main(String[] args) {
        function(3);
        function(6);
    }
}
