package org.example.Strings.Basic;

public class LargestOdd {
    public static void main(String[] args) {
        function("52");
        function("4206");
        function("35427");
        function("124568");
    }

    private static void function(String str) {
        int n = str.length();
        int i=n-1;

        for(; i>=0; i--) {
            int num = str.charAt(i)-48;
            if((num & 1) == 1) {
                break;
            }
        }
        if(i == -1)
            System.out.println(str);
        else
            System.out.println(str.substring(0, i+1));
    }
}
