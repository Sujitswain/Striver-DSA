package org.example.Arrays.Medium;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        function(new int[] {1,1,1,2,2,2,2,3}, 2);
    }
    private static void function(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                                    (a, b) -> b.getValue() - a.getValue()
                                );
        for(int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        pq.addAll(mp.entrySet());

        List<Integer> topKFrequent = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            topKFrequent.add(pq.poll().getKey());
        }

        System.out.println(topKFrequent);
    }
}
