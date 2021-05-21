package tree.solution236;

import sun.reflect.generics.tree.Tree;
import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 * 二次遍历方法：先寻找两个节点的祖先列表，然后求出它们的最后一个相同元素
 * 只有后序遍历时，当前栈中存放的才是当前节点的祖先节点元素
 * @author Billion
 * @create 2021/05/09 18:34
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> first = getPath(root, p);
        List<TreeNode> second = getPath(root, q);
        int len = Math.min(first.size(), second.size());
        int i = 0;
        for (; i < len; i++) {
            if(first.get(i) != second.get(i)) break;
        }
        return first.get(i - 1);
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> res = new ArrayList<>();
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode current = root;
        TreeNode prev = null;
        while (!st.isEmpty() || current != null){
            while (current != null){
                st.offerLast(current);
                current = current.left;
            }
            //当前节点左子树为空或左子树已经遍历完毕
            current = st.pollLast();
            if(current ==  target) {
                res.addAll(st);
                res.add(current);
                return res;
            }
            if(current.right == null || current.right == prev){
                //右子树为空或右子树已经访问完毕，可以后序访问当前节点
                prev = current;
                current = null;
            }else {
                st.offerLast(current);
                current = current.right;
            }
        }
        return res;
    }
}
