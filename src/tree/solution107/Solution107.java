package tree.solution107;

import tree.entity.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历2，自底向上、自左向右遍历
 * @author Billion
 * @create 2021/04/29 22:46
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> ret = new LinkedList<>();
        if(root == null) return (LinkedList<List<Integer>>)ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            ret.offerFirst(levelList);
        }
        return (LinkedList<List<Integer>>) ret;
    }
}
