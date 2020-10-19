package Lists;
import java.util.*;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(5, new ListNode(7, null)));
        ListNode list2 = new ListNode(1, new ListNode(4, new ListNode(6, null)));
        ListNode list3 = new ListNode(2, new ListNode(3, null));
        ListNode[] input = new ListNode[]{list1, list2, list3};
        ListNode reversed = mergeKLists(input);
        while(reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// TC: (nlogk), CS: O()
/* 
    O( n * log( k ) ). For n elements we will insert and remove each from the heap. This entails O( n * 2log( k ) ) work and just becomes O( n * log( k ) ) after constants are dropped.

    n = total elements across all lists
    k = number of sorted lists passed to us

    Insertion and removal from a binary heap takes O( log( n ) ) time where n is the total items in the heap.

    Heap is generally preferred for priority queue implementation because heaps provide better performance compared arrays or linked list.
    In a Binary Heap, getHighestPriority() can be implemented in O(1) time, 
    insert() can be implemented in O(Logn) time and 
    deleteHighestPriority() can also be implemented in O(Logn) time.
*/