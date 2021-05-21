package tree.solution110;

import tree.entity.TreeNode;

/**
 * 判断是否是平衡二叉树
 * @author Billion
 * @create 2021/04/30 17:06
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;
    }
    public int calculateHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
}
