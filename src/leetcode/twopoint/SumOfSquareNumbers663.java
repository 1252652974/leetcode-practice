package leetcode.twopoint;

import javax.xml.ws.FaultAction;

/**
 * @ClassName: SumOfSquareNumbers
 * @description:  判断一个非负整数是否为两个整数的平方和。
 * @author: liuliang
 * @create: 2020-11-30 21:55
 */
public class SumOfSquareNumbers663 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(7));
    }
    public static boolean judgeSquareSum(int target) {
        int i = 1;
        int j = target >> 1;
        while (i<j) {
            int s = (int)(Math.pow(i,2) + Math.pow(j,2));
            if (s==target) {
                return true;
            } else if (s>target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
