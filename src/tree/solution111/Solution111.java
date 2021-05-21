package tree.solution111;

import tree.entity.TreeNode;

/**
 * 二叉树的最小深度，version1深度优先遍历
 * @author Billion
 * @create 2021/04/30 17:27
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
