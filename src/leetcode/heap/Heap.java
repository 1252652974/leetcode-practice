package leetcode.heap;

import com.sun.tracing.dtrace.StabilityLevel;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Heap
 * @Description: 堆
 * @Author liang_liu
 * @Date 2020/7/13
 * @Version V1.0
 **/

public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    //堆化实际上有两种，从下往上和从上往下。这里我先讲从下往上的堆化方法。
    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
            swap(a, i, i/2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = i/2;
        }
    }

    private void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }

    //大顶堆移除最大元素
    public void removeMax() {
        if (count == 0) return; // 堆中没有数据
        a[1] = a[count]; --count; heapify(a, count, 1);}private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos); i = maxPos;
        }
    }

    public static String reverseWords(String s) {
        List<String> rst = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        boolean flag = false;
        s = ' '+ s + ' ';
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char i2 = s.charAt(i);
            boolean b = s.charAt(i + 1 < length - 1 ? i + 1 : length - 1) == ' ';
            if(i2 == ' ' && !flag) {
                if(!b) {
                    flag = true;
                }
            } else if (i2 == ' ' && flag) {
                if (b) {
                    flag = false;
                }
                rst.add(temp.toString());
                temp.setLength(0);
            }
            if (flag && i2 != ' ') {
                temp.append(i2);
            }
        }
        StringBuilder r = new StringBuilder();
        for (int i = rst.size()-1; i >= 0; i--) {
            r.append(rst.get(i) + " ");
        }
        int i = r.length() - 1;
        return r.toString().substring(0, i>0?i:0);
    }

    public static void main(String[] args) {
        /*String the_sky_is_blue = reverseWords("  hello world!  ");
        System.out.println(the_sky_is_blue);*/
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(0);
        ListNode s3 = new ListNode(1);
        s1.next = s2;
        s2.next = s3;

        System.out.println( getDecimalValue(s1));
    }

    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; } }

    public static int getDecimalValue(ListNode head) {
         ListNode t = head;
         int lenth = 0;
         while (t != null) {
             lenth++;
             t = t.next;
         }
         int rst = 0;
        while (head != null) {
            rst += head.val<<(--lenth);
            head = head.next;
        }
         return rst;
    }


}
