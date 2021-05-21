package tree.solution104;

import tree.entity.TreeNode;

/**
 * 二叉树的最大深度
 * @author Billion
 * @create 2021/04/29 20:59
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right? left + 1: right + 1;
    }
}
