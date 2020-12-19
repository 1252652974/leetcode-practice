package leetcode.dynamicprogramming;

import javax.xml.transform.Source;

/**
 * @ClassName: Rob
 * @description: 打家劫舍 198
 * @author: liuliang
 * @create: 2020-12-19 09:31
 */
public class Rob {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
