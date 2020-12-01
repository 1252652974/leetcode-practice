package leetcode.twopoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.RecursiveAction;

/**
 * @ClassName: ReverseString345
 * @description: 反转字符串中的元音字符
 * @author: liuliang
 * @create: 2020-11-30 22:11
 */
public class ReverseString345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (j>=i) {
            if (!vowels.contains(s.charAt(i))) {
                result[i] = s.charAt(i);
                i++;
            } else if (!vowels.contains(s.charAt(j))) {
                result[j] = s.charAt(j);
                j--;
            } else {
                result[i] = s.charAt(j);
                result[j] = s.charAt(i);
                i++; j--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));;
    }
}
