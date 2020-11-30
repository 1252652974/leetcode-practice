package leetcode.tree;

import com.jayway.jsonpath.internal.function.numeric.Min;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @ClassName Solution783
 * @Description: TODO
 * @Author liang_liu
 * @Date 2020/7/17
 * @Version V1.0
 **/
public class Solution783 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int max = Integer.MAX_VALUE;
    public static void minDiffInBST(TreeNode root) {
        if (root.left == null && root.right == null) return;
        if (root.left != null) {
            int val =  (root.val - root.left.val) > 0?(root.val - root.left.val):(root.left.val-root.val);
            max = max > val?val:max;
            minDiffInBST(root.left);
        }
        if (root.right != null) {
            int val =  (root.val - root.right.val) > 0?(root.val - root.right.val):(root.right.val-root.val);
            max = max > val?val:max;
            minDiffInBST(root.right);
        }
    }

    // 先序遍历
    // 如果节点 X 存储在数组中下标为 i 的位置，下标为 2 * i 的位置存储的就是左子节点，下标为 2 * i + 1 的位置存储的就是右子节点。
    //lic static int[] mi
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(90);
        TreeNode node2 = new TreeNode(69);
        TreeNode node4 = new TreeNode(49);
        TreeNode node5 = new TreeNode(89);
        TreeNode node6 = new TreeNode(52);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;
        minDiffInBST(node1);
        System.out.println(max);
    }
}
