package tree.solution199;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树右视图，
 * 版本1：层次遍历
 * @author Billion
 * @create 2021/05/09 12:57
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return  res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null) queue.offer(treeNode.left);
                if(treeNode.right != null) queue.offer(treeNode.right);
                if (i == size - 1) res.add(treeNode.val);
            }
        }
        return res;
    }
}
