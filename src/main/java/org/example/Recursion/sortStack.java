package org.example.Recursion;

import java.util.List;
import java.util.Stack;

public class sortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        List.of(1,3,4,2,5).stream().forEach(a -> st.push(a));
        recursionMethod(st);

        System.out.println(st);
    }
    private static void recursionMethod(Stack<Integer> st) {
        if(st.size() == 1)
            return;
        int top = st.pop();
        recursionMethod(st);
        insertLast(st, top);
    }
    private static void insertLast(Stack<Integer> st, int n) {
        if(st.isEmpty() || st.peek() > n) {
            st.push(n);
            return;
        }
        int top = st.pop();
        insertLast(st, n);
        st.push(top);
    }
}
