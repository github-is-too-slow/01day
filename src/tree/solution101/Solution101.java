package tree.solution101;

import tree.entity.TreeNode;

/**
 * 对称二叉树
 * @author Billion
 * @create 2021/04/28 16:54
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
