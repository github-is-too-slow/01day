package tree.solution129;

import sun.reflect.generics.tree.Tree;
import tree.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 求根到叶子节点数字之和，
 * 当找到叶子节点后再计算数字和，时间复杂度O(n2)，不推荐
 * @author Billion
 * @create 2021/05/03 22:18
 */
public class Solution129 {
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left == null && treeNode.right == null){
                sum += calculate(treeNode);
            }else{
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                    map.put(treeNode.left, treeNode);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                    map.put(treeNode.right, treeNode);
                }
            }
        }
        return sum;
    }

    int calculate(TreeNode treeNode){
        int num = 0;
        int exp = 0;
        while (treeNode != null){
            num += treeNode.val * Math.pow(10, exp);
            treeNode = map.get(treeNode);
            exp++;
        }
        return num;
    }
}
