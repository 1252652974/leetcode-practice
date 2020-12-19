package leetcode.linkedlist;

import javafx.beans.binding.When;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Stack;

/**
 * @ClassName: AddTwoNumbers
 * @description:
 * @author: liuliang
 * @create: 2020-12-19 09:47
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Stack<Integer> stack1 = new Stack();
        Stack stack2 = new Stack();
        do {
            stack1.add(l1.val);
            l1 = l1.next;
        } while (l1 != null);
        do {
            stack2.add(l2.val);
            l2 = l2.next;
        } while (l2 != null);
        do {
            sb1.append(stack1.pop());
        } while (!stack1.isEmpty());
        do {
            sb2.append(stack2.pop());
        } while (!stack2.isEmpty());
        char[] chars = bigNumAdd(sb1.toString() ,sb2.toString()).toCharArray();
        ListNode listNode = new ListNode(Integer.valueOf(chars[chars.length-1]+""));
        ListNode now = listNode;
        for (int i = chars.length-2; i >= 0; i--) {
            now.next = new ListNode(Integer.valueOf(chars[i]+""));
            now = now.next;
        }
        return listNode;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode((l1.val + l2.val)%10);
        ListNode now = listNode;
        // 保存进位
        int an = (l1.val + l2.val)/10;
        int n1=0,n2=0;
        do {

            n1 = l1 == null? 0 : l1.val;
            n2 = l2 == null? 0 : l2.val;
            int i = n1 + n2;
            now.next = new ListNode(i%10 + an);
            now = now.next;
            an = i/10;
            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null && l2 != null);
        return listNode;
    }

    public static String  bigNumAdd(String strNum1, String strNum2) {
        char[] chars1 = strNum1.toCharArray();
        char[] chars2 = strNum2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        boolean oneBiger = len1 > len2;
        int len = Integer.max(len1, len2);
        StringBuilder targetSb = new StringBuilder();
        //进位
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int temp;
            int idx1 = len1 - 1 - i;
            int idx2 = len2 - 1 - i;
            if (oneBiger) {
                if (i < len2) {
                    temp = Integer.parseInt(chars1[idx1] + "") + Integer.parseInt(chars2[idx2] + "") + carry;
                } else {
                    temp = Integer.parseInt(chars1[idx1] + "") + carry;
                }
            } else {
                if (i < len1) {
                    temp = Integer.parseInt(chars1[idx1] + "") + Integer.parseInt(chars2[idx2] + "") + carry;
                } else {
                    temp = Integer.parseInt(chars2[idx2] + "") + carry;
                }
            }
            carry = 0;
            if (temp > 9) {
                carry = 1;
                targetSb.append(temp - 10);
            } else {
                targetSb.append(temp);
            }
        }
        if (carry > 0) {
            targetSb.append(carry);
        }
        return  targetSb.reverse().toString();
    }

    public static void main(String[] args) {
        char[] chars = "342".toCharArray();

        ListNode listNode = new ListNode(Integer.valueOf(chars[chars.length-1]+""));
        ListNode now = listNode;
        for (int i = chars.length-2; i >= 0; i--) {
            now.next = new ListNode(Integer.valueOf(chars[i]+""));
            now = now.next;
        }

        String rst2 = "465";
        ListNode listNode1 = new ListNode(Integer.valueOf(rst2.charAt(rst2.length()-1)+""));
        ListNode nowq = listNode1;
        for (int i = rst2.length()-2; i >= 0; i--) {
            nowq.next = new ListNode(Integer.valueOf(rst2.charAt(i)+""));
            nowq = nowq.next;
        }
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        System.out.println();
    }
}
