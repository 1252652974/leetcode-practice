package leetcode.twopoint;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName EraseOverlapIntervals
 * @Description: 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * @Author liang_liu
 * @Date 2020/12/30
 **/
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按左区间排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int count = 0;
        int i = 0,j=1;  //i指向待比较的左边区间，j指向待比较的右边区间
        // 如果前后两个是包含关系，删除那个大的
        // 如果是[1,8], [7, 9]这种交叉关系，保留右边界小的，另外一个删除
        for (i = 0; i < intervals.length-1 && j<=intervals.length-1; i++,j++) {
            if (intervals[i][1] > intervals[j][0]) {
                i = intervals[i][1] < intervals[j][1] ? i - 1 : j - 1;
                count++;
            } else {
                i = j-1;
            }
        }
        return count;
    }
}
