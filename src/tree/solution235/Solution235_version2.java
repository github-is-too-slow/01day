package tree.solution235;

import tree.entity.TreeNode;

/**
 * 搜索二叉树的最近公共祖先，
 * 一次遍历方式，迭代版本
 * @author Billion
 * @create 2021/05/09 18:04
 */
public class Solution235_version2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else {
                return root;
            }
        }
    }
}
