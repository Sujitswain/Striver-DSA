package org.example.BinarySearch.BSonAnswers;

public class SQRT {

    public static void function(int n) {
        int s = 1;
        int e = n;
        int ans = 0;

        while(s<=e) {
            int m = s+(e-s)/2;
            if(m*m <= n) {
                ans = m;
                s = m+1;
            }
            else {
                e = m-1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        function(64);
        function(74);
        function(24);
        function(54);
    }
}
