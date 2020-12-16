package leetcode.dynamicprogramming;

/**
 * @ClassName: FindMaxForm
 * @description: 找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *   x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * @author: liuliang
 * @create: 2020-12-13 10:45
 */
public class FindMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length <= 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        int oneNum;
        int zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;

            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            /*
                dp[i][j] 的结果有两种情况：
                    1、当前状态(dp[i][j])
                    2、上一个状态(dp[i - zeroNum][j - oneNum])的个数 + 1
             */
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
