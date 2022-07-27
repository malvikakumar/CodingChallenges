import java.util.*;

public class KthMostFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        
        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init queue 'the less frequent element first'
        Queue<Integer> queue = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the queue
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            queue.add(n);
            if (queue.size() > k) queue.poll();    
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = queue.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,8,2,5,2,5};
        int[] result = topKFrequent(arr, 2);
        Arrays.stream(result).forEach(System.out::println);
    }
}

// TC: O(N log k) if k<N and O(N) if k=N
// SC: O(N+k) to store the hash map with not more N elements and a queue with k elements
