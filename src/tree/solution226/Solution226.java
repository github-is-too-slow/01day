package tree.solution226;

import tree.entity.TreeNode;

/**
 * 翻转二叉树，前序遍历或后序遍历均可以
 * @author Billion
 * @create 2021/05/09 16:17
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
