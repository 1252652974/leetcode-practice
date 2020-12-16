package leetcode.greek;

/**
 * @ClassName: SmallestString
 * @description: 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值（a的数值是0，z是28） 等于 k 的 字典序最小 的字符串（字符串由若干小写字符组成，。
 * @author: liuliang
 * @create: 2020-12-13 07:56
 */
public class SmallestString {
    public static String getSmallestString(int n, int k) {
        StringBuilder rst = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int bound = k-26*(i-1);
            if (bound <= 0) {
                rst.append('a');
                k -= 1;
            } else {
                rst .append((char)(bound + 'a' - 1));
                k -= bound;
            }
        }
        return rst.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
    }
}
