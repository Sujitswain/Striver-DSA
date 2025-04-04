package org.example.Graph;

import java.util.*;

public class TopologicalSort {
    /*
    *
    *   5 -------> 0 <------- 4
    *   |                     |
    *   |                     |
    *   \/                    \/
    *   2 -------> 3 -------> 1
    * */
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {5, 0},
                {4, 0},
                {5, 2},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<n; i++)
            adjList.put(i, new ArrayList<>());

        for(int[] arr : edges)
            adjList.get(arr[0]).add(arr[1]);

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> topoStack = new Stack<>();

        for(int i=0; i<n; i++) {
            if(!visited.contains(i))
                dfsTraversal(i, adjList, visited, topoStack);
        }

        while(!topoStack.isEmpty()) {
            System.out.print(topoStack.peek() + " ");
            topoStack.pop();
        }

    }

    private static void dfsTraversal(int start, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Stack<Integer> topoStack) {
        visited.add(start);

        for(int neighbour : adjList.get(start)) {
            if(!visited.contains(neighbour))
                dfsTraversal(neighbour, adjList, visited, topoStack);
        }
        topoStack.push(start);
    }
}
