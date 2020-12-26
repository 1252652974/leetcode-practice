package leetcode.tree.dfs;

import java.util.*;

/**
 * @ClassName PermutationStr
 * @Description: 打印出ABC的全排列，给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @Author liang_liu
 * @Date 2020/12/4
 **/
public class PermutationStr {
    // 深度优先算法实现
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        // 处理特殊情况
        if (nums.length == 0) {
            return rst;
        }
        // 定义存储状态的一些变量
        //1 那些变量被使用过了
        boolean[] used = new boolean[nums.length];
        // 现在的结果集里面有什么
        Deque<Integer> path = new ArrayDeque<Integer>();
        // 当前是第几层
        int level = 0;
        dfs(nums, rst, level, path, used);
        return rst;
    }

    private void dfs(int[] nums, List<List<Integer>> rst, int level, Deque<Integer> path, boolean[] used) {
        if (level == nums.length) {
            rst.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, rst, level+1, path, used);
            // 状态回退，回溯，深度遍历进了最深处，回到上一层继续遍历
            used[i] = false;
            path.removeLast();
        }
    }
}
