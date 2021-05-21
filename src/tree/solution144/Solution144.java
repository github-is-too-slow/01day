package tree.solution144;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历二叉树
 * 递归版本
 * @author Billion
 * @create 2021/05/03 23:15
 */
public class Solution144 {
    List<Integer> ret = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ret;
    }

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        ret.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
