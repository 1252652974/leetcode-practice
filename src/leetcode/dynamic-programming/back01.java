package leetcode;

import com.jayway.jsonpath.internal.function.numeric.Max;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName back01
 * @Description: 0 1背包问题
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 * @Author liang_liu
 * @Date 2020/7/8
 * @Version V1.0
 **/
public class back01 {
    private static int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private static int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 16; // 背包承受的最大重量



    private static void f(int n1, int w1) { // n1 表示现在是判断第几件
        // 递归出口
        if (n1 == n || w1 == w) {
            if (w1 > maxW) maxW = w1;
            return;
        }
        // 下面算法的目的是递归把所有可能性遍历一遍
        // 情况1 不装这一件
        f(n1+1, w1);
        // 情况2 装(必须先满足条件)
        if (w1 + weight[n1] <= w) {
            f(n1+1, w1+weight[n1]);
        }
    }

    private static int dp() {
        boolean[][] states = new boolean[n][w+1]; // 默认值false
        states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) { states[0][weight[0]] = true; }
        for (int i = 1; i < n; i++) {
            // 选第i件
            for (int j = 0; j <= w-weight[i]; j++) {
                if(states[i-1][j] = true) states[i][j+weight[i]] = true;
            }
            // 不选第i件
            for (int j = 0; j < w; j++) {
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
        }
        return 0;
    }
    // 动态规划常用模板
    /*private static int dp(int[][] matrix, int n) {
            int[][] states = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
                sum += matrix[0][j];
                states[0][j] = sum;
            }
            sum = 0;
            for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
                sum += matrix[i][0];
                states[i][0] = sum;
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j < n; ++j) {
                    states[i][j] =
                            matrix[i][j] + Math.min(states[i][j-1], states[i-1][j]);
                }
            }
            return states[n-1][n-1];
        }*/
    private static int count = Integer.MAX_VALUE;
    public static int minPathSum(int[][] grid) {
        run(grid, grid[0].length-1, grid.length-1, 0, 0, grid[0][0]);
        System.out.println(count);
        return count;
    }

    public static void run(int[][] grid, int m, int n, int i, int j, int length) {
        // 回溯剪枝
        if(i==m) {
            for (int k = j; k < n; k++) {
                length += grid[i][k];
            }
            if(length < count) count = length;
            return;
        }

        if(j==n) {
            for (int k = i; k < m; k++) {
                length += grid[k][j];
            }
            if(length < count) count = length;
            return;
        }
        // 向右
        run(grid, m, n, i+1, j, length+grid[i+1][j]);
        // 向下
        run(grid, m, n, i, j+1, length+grid[i][j+1]);
    }
    public static void main(String[] args) {
        /*f(0, 0);
        System.out.println(maxW); // 9
        f(0, 0);
        System.out.println(maxW); // 10*/
        /*int[][] grid = {{0,1},{1,0}};
        minPathSum(grid);*/
        /*System.out.println(grid.length);
        System.out.println(grid[0].length);*/
        /*System.out.println(grid[0][0]);
        System.out.println(grid[0][1]);
        System.out.println(grid[0][2]);*/
        //System.out.println(isHappy(19));
        /*char c = '1';
        System.out.println(Math.pow(Integer.valueOf(c+""), 2));*/
        int[] ints = {1,3,45,6,8,98,3,3};
        lastStoneWeight(ints);
    }

    public static boolean isHappy(int n) {
        String s = String.valueOf(n);
        int val;
        HashSet<String> set = new HashSet<>();
        while (!s.equals("1")) {
            val = 0;
            for (int i = 0; i < s.length(); i++) {
                val += Math.pow(Integer.valueOf(s.charAt(i)+""), 2);
            }
            s = String.valueOf(val);
            int size = set.size();
            set.add(s);
            if (set.size() == size) {
                return false;
            }
        }
        System.nanoTime();
        return true;

    }
    class Solution {
        public int multiply(int A, int B) {
            if(A==0||B==0) return 0;
            else return plus(A,B,A);
        }
        public int plus(int A,int B,int n){
            if(B!=1){
                return plus(n,B-1,A+n);
            }
            return n;
        }
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int length = stones.length;
        for (int i = 0; i < length; i++) {
            if (stones[i] != 0 && stones[i+1] == 0) {
                return stones[i];
            }
            if (stones[i] == 0) {
                return 0;
            }
            stones[length-i-1] -= stones[length-i-2];
            stones[length-i-2] = 0;
            System.out.println(Arrays.toString(stones));
        }
        return 0;
    }
}
