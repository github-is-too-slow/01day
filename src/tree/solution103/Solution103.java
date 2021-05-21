package tree.solution103;

import tree.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形的层次遍历
 * @author Billion
 * @create 2021/04/29 17:40
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            if(level % 2 == 0){//从右到左
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    levelList.offerFirst(treeNode.val);
                    if(treeNode.left != null){
                        queue.offer(treeNode.left);
                    }
                    if(treeNode.right != null){
                        queue.offer(treeNode.right);
                    }
                }
            }else{//从左到右
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    levelList.offerLast(treeNode.val);
                    if(treeNode.left != null){
                        queue.offer(treeNode.left);
                    }
                    if(treeNode.right != null){
                        queue.offer(treeNode.right);
                    }
                }
            }
            ret.add((LinkedList<Integer>) levelList);
            level += 1;
        }
        return ret;
    }
}
