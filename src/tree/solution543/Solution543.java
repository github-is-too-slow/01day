package tree.solution543;

import tree.entity.TreeNode;

/**
 * 二叉树的直径
 *
 * 方案1：假设空节点返回-1，
 * 那么当前节点的最大直径：L + R + 2;
 * 当前节点返回max(L, R) + 1;
 * @author Billion
 * @create 2021/05/23 23:33
 */
public class Solution543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left + right + 2;
        max = Math.max(sum, max);
        return Math.max(left, right) + 1;
    }
}
