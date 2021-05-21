package tree.solution98;

import tree.entity.TreeNode;

/**
 * 中序遍历递归方式实现
 * @author Billion
 * @create 2021/04/24 14:30
 */
public class Solution98Version2 {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode root, long min, long max){
        if (root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
