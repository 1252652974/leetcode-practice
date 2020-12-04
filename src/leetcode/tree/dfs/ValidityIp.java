package leetcode.tree.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ValidityIp
 * @Description: 192168801，这个字符串有多少个合法的ip组合方法（除了0以外不能以0开头，四个255以内的数）
 * 192.168.0.1,192.16.80.1,
 * @Author liang_liu
 * @Date 2020/12/4
 **/
public class ValidityIp {

    private static void ValidityIp(String ipStr, int level, int index, String s) {
        if (level == 5 || index == ipStr.length() - 1) {
            if (level == 5 && index == ipStr.length() - 1) {
                System.out.println(s);;
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            String c = ipStr.substring(index+1, i);
            if(c.equals("")) break;
            if (Integer.valueOf(c) < 256 && (c.equals("0")|| !c.startsWith("0"))) {
                s = s + c;
                ValidityIp(ipStr, level + 1, index + i, s);
                s= s.substring(0, i);
            }
        }
    }

    public static void main(String[] args) {
        ValidityIp("19216801", 0, -1, "");
    }
}
