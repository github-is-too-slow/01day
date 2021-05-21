package tree.solution100;

import tree.entity.TreeNode;

/**
 * 相同二叉树
 * @author Billion
 * @create 2021/04/28 16:48
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
