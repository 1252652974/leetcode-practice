package leetcode.tree.dfs;

import java.util.*;

/**
 * @ClassName: PondSizes
 * @description: 面试题 16.19. 水域大小  https://leetcode-cn.com/problems/pond-sizes-lcci/
 * @author: liuliang
 * @create: 2020-12-26 08:28
 */
public class PondSizes {
    int maxCount = 0;
    public int[] pondSizes(int[][] land) {
        List<Integer> rst = new ArrayList<>();
        int length = land.length;
        int hight = land[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < hight; j++) {
                if (land[i][j] == 0) {
                    bfs(land, length, hight, i, j);
                    rst.add(maxCount);
                    maxCount = 0;
                }
            }
        }
        int[] r = new int[rst.size()];
        for (int i = 0; i < rst.size(); i++) {
            r[i] = rst.get(i);
        }
        Arrays.sort(r);
        return r;
    }

    private void  bfs(int[][] land, int l, int h, int i, int j) {
        if (i < 0 || j < 0 || i >= l || j >= h || land[i][j] != 0) {
            return;
        }
        land[i][j] = 1;
        maxCount++;
        bfs(land, l, h, i + 1, j);
        bfs(land, l, h, i, j + 1);
        bfs(land, l, h, i + 1, j + 1);
        bfs(land, l, h, i - 1, j);
        bfs(land, l, h, i, j - 1);
        bfs(land, l, h, i - 1, j - 1);
        bfs(land, l, h, i - 1, j + 1);
    }
}
