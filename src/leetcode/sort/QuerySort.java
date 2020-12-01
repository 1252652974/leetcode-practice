package leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: QuerySort
 * @description: 手写快速排序 8.13
 * @author: liuliang
 * @create: 2020-12-01 20:10
 */
public class QuerySort {
    public static void main(String[] args) {
        int[] nums = new int[]{8,4,7,63,123};
        sort(nums, 0, nums.length -  1);
        System.out.println(Arrays.toString(nums));
    }

    public static void qSort(int[] nums, int left ,int right) {
        if (left>=right) return;
        int i= left,j= right,temp, pot = nums[left];
        // 这个多加了=号，导致了死循环
        while (i < j) {
            // 右指针的值比pot小时，把右指针的值赋值给左指针位置，左指针后移
            while (nums[j]>=pot) {
                j--;
            }
            while (nums[i]<=pot) {
                i++;
            }
            if (i<j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[i] = pot;
        qSort(nums, left, i-1);
        qSort(nums, i+1, right);
    }

    // 本来想拆分成两个方法，后来发现值传递改不了指针位置
    public static int getMid(int[] nums,  int left ,int right) {
        int pot = nums[left];
        while (left <= right) {
            // 右指针的值比pot小时，把右指针的值赋值给左指针位置，左指针后移
            while (nums[right]>pot) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left]<=pot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = pot;
        return right;
    }

    // 这种写法是支持存在重复元素的
    public static void sort(int[] arr, int left, int right) {
        if(left > right)
            return;
        int baseVal = arr[left];
        int i = left, j = right;
        while(i != j) {
            while(arr[j] >= baseVal && j > i) {
                j--;
            }
            while(arr[i] <= baseVal && j > i) {
                i++;
            }
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = baseVal;
        sort(arr, left, i-1);
        sort(arr, i+1, right);
    }

}
