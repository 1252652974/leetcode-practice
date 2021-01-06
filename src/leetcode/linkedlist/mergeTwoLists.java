package leetcode.linkedlist;

/**
 * @ClassName mergeTwoLists
 * @Description: TODO
 * @Author liang_liu
 * @Date 2021/1/5
 **/
public class mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode p = node;
        while (l1 == null || l2 == null) {
            if (l1.val > l2.val) {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            p = p.next;
        }
        node.next = l1 == null ? l2:l1;
        return node.next;
    }
}
