package org.example.Recursion;

import java.util.*;

public class generateParenthesis {
    public static void main(String[] args) {
        function(3);
    }
    private static void function(int n) {
        // iterativeSolution(n);
        recursiveSolution(n, "", 0, 0);
    }
    private static void recursiveSolution(int n, String str, int openCount, int closeCount) {
        if(str.length() == 2*n) {
            System.out.println(str);
            return;
        }

        if(openCount < n)
            recursiveSolution(n, str+"(", openCount+1, closeCount);

        if(closeCount < openCount)
            recursiveSolution(n, str+")", openCount, closeCount+1);
    }
    private static void iterativeSolution(int n) {
        List<String> l = new ArrayList<>();

        Stack<String[]> st = new Stack<>();
        st.push(new String[] {"", "0", "0"});

        while(!st.isEmpty()) {
            String[] current = st.pop();
            String str = current[0];
            Integer openCount = Integer.parseInt(current[1]);
            Integer closeCount = Integer.parseInt(current[2]);

            if(str.length() == 2*n) {
                l.add(str);
                continue;
            }
            if(openCount < n)
                st.push(new String[] {str + "(", (openCount + 1)+"", closeCount+""});

            if(closeCount < openCount)
                st.push(new String[] {str + ")", openCount+"", (closeCount+1)+""});
        }
        System.out.println(l);
    }
}
