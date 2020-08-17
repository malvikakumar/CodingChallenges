// Design a class to find the kth largest element in a stream.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
import java.util.PriorityQueue;

public class kthLargestElementInStream {
    PriorityQueue<Integer> q;
    int k;

    public void KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public kthLargestElementInStream(PriorityQueue<Integer> q, int k) {
        this.q = q;
        this.k = k;
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
