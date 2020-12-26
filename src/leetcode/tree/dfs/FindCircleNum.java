package leetcode.tree.dfs;

/**
 * @ClassName: FindCircleNum  https://leetcode-cn.com/problems/friend-circles/submissions/
 * @description: 思想：bfs思想，连通块的个数，我们从每个未被访问的节点开始深搜，每开始一次搜索就增加 count 计数器加1
 * ，并且要修改这个朋友圈的遍历包含含的人的标记为访问过
 * @author: liuliang
 * @create: 2020-12-26 12:34
 */
public class FindCircleNum {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
