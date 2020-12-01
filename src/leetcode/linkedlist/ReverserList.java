package leetcode.linkedlist;

import java.util.ArrayList;

/**
 * @ClassName ReverserList
 * @Description: TODO
 * @Author liang_liu
 * @Date 2020/12/1
 **/
public class ReverserList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 使用递归实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    // 使用栈实现

    // 使用头插法
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> objects = new ArrayList<>();
        ListNode node = new ListNode(-1);
        while (listNode.next != null) {
            ListNode memo = listNode.next;
            listNode.next = node.next;
            node.next = listNode;
            listNode = memo;
        }
        while (node.next != null) {
            objects.add(node.val);
            node = node.next;
        }
        return objects;
    }
}
