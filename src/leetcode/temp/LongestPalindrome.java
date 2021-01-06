package leetcode.temp;

/**
 * @ClassName LongestPalindrome
 * @Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 输入: "abccccdd"
 * 输出: 7
 * 解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @Author liang_liu
 * @Date 2021/1/5
 **/
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] nums = new int['z'-'A' + 1];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - 'A'] ++;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - nums[i]%2;
        }
        if (res == chars.length) {
            return res;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }
}
