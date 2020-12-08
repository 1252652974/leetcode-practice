package leetcode.slidingwindow;

/**
 * @ClassName ShortestSubString
 * @Description: 最短包含子串，输入一个字符串和目标字符串，在字符串中找到包含目标串所有字符的，没有输出""
 * input：s1:ABCDEFG  s2:BF
 * output:BCD
 * @Author liang_liu
 * @Date 2020/12/8
 **/
public class ShortestSubString {
    private static String sss(String str, String target) {
        char[] s1 = str.toCharArray();
        char[] s2 = target.toCharArray();
        int[] rst = new int[256];
        int i=0,j=1;
        String rstr = "";
        boolean sw;
        while (j>i) {
            sw = true;
            for (int k = 0; k < s2.length; k++) {
                if (rst[s2[k]] == 0) {
                    sw = false;
                }
            }
            if (sw || j==s1.length-1) {
                if (sw) {
                    if (rstr.equals("") || (j-i)<rstr.length()) {
                        rstr = str.substring(i, j);
                    }
                }
                rst[s1[i ++]] --;
            } else {
                rst[s1[j ++]] ++;
            }
        }
        return rstr;
    }

    public static void main(String[] args) {
        System.out.println(sss("ABCDEFG", "BF"));
    }
}
