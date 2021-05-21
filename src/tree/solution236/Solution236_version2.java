package tree.solution236;

import tree.entity.TreeNode;

/**
 * 二叉树公共祖先
 * 一次遍历递归算法：
 * 若root为空，返回null
 * 若root等于p或者q，则直接返回root
 * 则此时root不等于null且不等于p/q，
 * 遍历左子树得到lson,
 * 遍历右子树得到rson,
 * 若lson和rson均不为空，则root为最近公共祖先
 * 若其中一个为空，则另一个要么是等于p/q，要么就是最近公共祖先，直接返回
 * 若二者均为空，则返回null。
 * 从上述看来，此题仍然是后序遍历的变形，
 * @author Billion
 * @create 2021/05/09 21:40
 */
public class Solution236_version2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if(root == p || root == q) return root;
        //此时root不等于null且不等于p/q
        TreeNode lson = lowestCommonAncestor(root.left, p, q);
        TreeNode rson = lowestCommonAncestor(root.right, p, q);
        if(lson != null && rson != null) return root;
        else if(lson != null) return lson;
        else if(rson != null) return rson;
        return null;
    }
}
