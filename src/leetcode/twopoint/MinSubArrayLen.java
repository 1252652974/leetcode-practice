package leetcode.twopoint;

/**
 * @ClassName: MinSubArrayLen 209
 * @description: 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 *如果不存在符合条件的子数组，返回 0。
 * @author: liuliang
 * @create: 2020-12-20 09:49
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= s)
                return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    /**
     * @Description 虽然是双指针，但是可以看成一个队列去理解
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/
     * @Param [s, nums]
     * @return int
     **/
    public int minSubArrayLen1(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
