package leetcode.bitoperation;

/**
 * @ClassName: RangeBitwiseAnd
 * @description: 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。给定范围 [m, n]，
 * 其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。给定范围 [m, n]，
 * 其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * @author: liuliang
 * @create: 2020-12-16 20:33
 */
public class RangeBitwiseAnd {
    // 返回最高位的数据是0还是1
    static int msb(int m) {
        int count = 0;
        while (m > 0) {
            //System.out.println(Integer.toBinaryString(m));
            m = (m >> 1);
            //System.out.println(Integer.toBinaryString(m));
            count ++;
        }
        return count - 1;
    }
    // 把第i位设置成1
    static int setBit(int res, int i) {
        return (res | (1 << i));
    }
    // 获取第I位上面的值
    static int getBit(int m, int i) {
        return ((m >> i) & 1);
    }
    public static int rangeBitwiseAnd(int m, int n) {
        int msb1 = msb(m);
        int msb2 = msb(n);
        if (msb1 != msb2) {
            return 0;
        }
        int msb = msb1;
        int rst = 0;
        while (msb >= 0) {
            int x = getBit(m, msb);
            int y = getBit(n, msb);
            if (x != y) {
                return  rst;
            } else if (x == 1) {
                rst = setBit(rst, msb);
            }
            msb --;
        }
        return rst;
    }

    public static int rangeBitwiseAnd1(int m, int n) {
        int rst = n;
        int msb = msb(n);
        if (msb(m) != msb) {
            return 0;
        }
        for (int i = 1; i < msb; i++) {
            System.out.println(Integer.toBinaryString(rst));
            rst = (rst & (1 << i));
            System.out.println(Integer.toBinaryString(rst));
            if (rst <= m) {
                return rst;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        /*System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(msb(Integer.MAX_VALUE));
        System.out.println(msb(Integer.MIN_VALUE));
        System.out.println(msb(1));
        System.out.println(Integer.toBinaryString(0x4e));
        System.out.println(Integer.toBinaryString(0x48));*/
        /// System.out.println(Integer.toHexString(rangeBitwiseAnd1(0x4a, 0x4e)));

        System.out.println(Integer.toBinaryString(1));
    }
}
