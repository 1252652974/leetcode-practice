package leetcode.twopoint;

import java.util.Arrays;

/**
 * @ClassName: twopoint
 * @description: 在有序数组中找出两个数，使它们的和为 target。
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author: liuliang
 * @create: 2020-11-30 21:13
 */
public class TwoPoint167 {
    // 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
    // 指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers==null) return null;
        int i = 0, j = numbers.length - 1;
        while (j>i) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum > target) {
                j --;
            } else {
                i ++;
            }
        }
        return  null;
    }
}
