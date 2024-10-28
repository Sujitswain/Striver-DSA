package org.example.Bitmanipulation;

public class OddEven {
    public static void main(String[] args) {
        function(34);
        function(33);
    }
    private static void function(int n) {
        System.out.println((n & 1) == 0);
    }
}
