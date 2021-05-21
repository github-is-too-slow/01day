package tree.solution113;

import sun.reflect.generics.tree.Tree;
import tree.entity.TreeNode;

import java.util.*;

/**
 * 二叉树所有路径之和
 * 广度优先遍历
 * @author Billion
 * @create 2021/05/03 16:50
 */
public class Solution113_version2 {
    List<List<Integer>> ret = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return ret;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));
        while (!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int sum = queueNode.sum + treeNode.val;
            if(treeNode.left == null && treeNode.right == null){
                if(sum == targetSum){
                    getPath(treeNode);
                }
            }else{
                if(treeNode.left != null){
                    map.put(treeNode.left, treeNode);
                    queue.offer(new QueueNode(treeNode.left, sum));
                }
                if(treeNode.right != null){
                    map.put(treeNode.right, treeNode);
                    queue.offer(new QueueNode(treeNode.right, sum));
                }
            }
        }
        return ret;
    }

    void getPath(TreeNode treeNode){
        LinkedList<Integer> path = new LinkedList<>();
        while(treeNode != null){
            path.addFirst(treeNode.val);
            treeNode = map.get(treeNode);
        }
        ret.add(path);
    }

    class QueueNode {
        TreeNode treeNode;
        int sum;
        QueueNode(TreeNode treeNode, int sum){
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }
}
