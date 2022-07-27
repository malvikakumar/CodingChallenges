public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode reversed = reverseList(head);
        while(reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode current = null, prev = null;
        while(head != null) {
            ListNode next = head.next;
            current = head;
            current.next = prev;
            prev = current;
            head = next;
        }
        return current;
    }
}