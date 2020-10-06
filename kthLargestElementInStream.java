// Design a class to find the kth largest element in a stream.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
import java.util.Collections;
import java.util.PriorityQueue;

class KthLargestElementInStream {
    PriorityQueue<Integer> q;
    int k;

    public KthLargestElementInStream(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        // q = new PriorityQueue<>(k, Collections.reverseOrder()); -> for kth smallest

        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) { // (q.peek() > n) for kth smallest
            q.poll();
            q.offer(n);
        }
        return q.peek(); // The head or front of the queue contains the least element as per the natural ordering
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargestElementInStream kth = new KthLargestElementInStream(3, arr);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }
}

// TC: O(n), SC: O(k) where k is capacity of priority queue