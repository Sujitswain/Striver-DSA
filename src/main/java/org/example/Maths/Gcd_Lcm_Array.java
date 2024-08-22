package org.example.Maths;

public class Gcd_Lcm_Array {

    public static int GCD(int a, int b) {
        if(b == 0)
            return a;

        return GCD(b, a%b);
    }

    public static void function(int[] arr) {
        int lcm = arr[0];
        int gcd=0;

        for(int i=1; i<arr.length; i++) {
            gcd = GCD(lcm, arr[i]);
            lcm = (lcm * arr[i])/gcd;
        }

        System.out.println("LCM: " + lcm);
    }

    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5,6});
        function(new int[] {1,2,8,3});
        function(new int[] {2,7,3,9,4});
    }
}
