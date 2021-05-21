package tree.solution235;

import tree.entity.TreeNode;

/**
 * 搜索二叉树的最近公共祖先，
 * 一次遍历方式，递归版本
 * @author Billion
 * @create 2021/05/09 18:26
 */
public class Solution235_version3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
