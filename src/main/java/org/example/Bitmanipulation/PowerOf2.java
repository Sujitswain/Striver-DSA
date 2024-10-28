package org.example.Bitmanipulation;

public class PowerOf2 {
    public static void main(String[] args) {
        int n = 32;
        if((n & (n-1)) == 0)
            System.out.println("yes");
        else
            System.out.println("No");
    }
}
