package tree.solution114;

import tree.entity.TreeNode;

/**
 * 二叉树展开为链表（前序遍历）
 * @author Billion
 * @create 2021/05/03 17:29
 */
public class Solution114 {
    TreeNode preNode = new TreeNode();
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode tmpLeft = root.left;
        TreeNode tmpRight = root.right;
        root.left = null;
        preNode.right = root;
        preNode = root;
        flatten(tmpLeft);
        flatten(tmpRight);
    }
}
