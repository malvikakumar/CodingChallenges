
package Lists;
import java.util.*;

public class DetectCycle {
    public static boolean hasCycle(ListNode head) {
       Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false; 
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println(hasCycle(head));

        head.next.next.next.next = head; 
        System.out.println(hasCycle(head));
    }
}
