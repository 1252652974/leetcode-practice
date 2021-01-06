package leetcode.slidingwindow;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description: 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @Author liang_liu
 * @Date 2021/1/5
 **/
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int  i = 0, j = 1;
        int min = 1, nowL = 1;
        int[] nums = new int[256];
        nums[chars[0]] ++;
        while (j < chars.length) {
            if (nums[chars[j]] == 0) {
                // 先把nums操作好在操作下标，弄错过一次
                nums[chars[j]] ++;
                nowL ++ ;
                j ++ ;
            } else {
                nums[chars[i]] --;
                i ++;
                nowL --;
            }
           min = Math.max(min, nowL);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
