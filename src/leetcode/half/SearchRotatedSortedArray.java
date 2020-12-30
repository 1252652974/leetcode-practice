package leetcode.half;

/**
 * @ClassName SearchRotatedSortedArray
 * @Description: 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引（升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ））
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * @Author liang_liu
 * @Date 2020/12/30
 **/
public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0 ,right = nums.length-1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 下面两个判断要加上，要不然当没有包含指定目标时会死循环
            if (left == mid) {
                if (nums[right] == target) {return right;} else return -1;
            }
            if (right == mid) {
                if (nums[left] == target) {return left;} else return -1;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[mid] >= target && nums[left] <= target) {
                    right = mid;
                } else {
                    left = mid;
                }
                continue;
            }
            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
