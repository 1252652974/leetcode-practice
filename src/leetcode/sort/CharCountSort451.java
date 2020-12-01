package leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: CharCountSort
 * @description:
 * @author: liuliang
 * @create: 2020-12-01 22:33
 */
public class CharCountSort451 {
    public static String frequencySort(String s) {
        int[] ints = new int[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i]]++;
        }
        PriorityQueue<Character> pq = new PriorityQueue(new Comparator<Character>(){
            public int compare(Character a, Character b) {
                return ints[b] - ints[a];
            }
        });
        // 将数据写入到PriorityQueue中
        for (int j = 0; j < 128 ; j++) {
            if (ints[j] != 0)
                pq.offer((char)j);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            while (ints[ch] > 0) {
                stringBuilder.append(ch);
                ints[ch]--;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("12253161434131657"));
    }
}
