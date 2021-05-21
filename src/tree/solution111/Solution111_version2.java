package tree.solution111;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Billion
 * @create 2021/04/30 18:45
 */
public class Solution111_version2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while(!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int depth = queueNode.depth;
            if(treeNode.left == null && treeNode.right == null) return depth;
            if(treeNode.left != null)
                queue.offer(new QueueNode(treeNode.left, depth + 1));
            if(treeNode.right != null)
                queue.offer(new QueueNode(treeNode.right, depth + 1));
        }
        return 0;
    }

    class QueueNode {
        TreeNode treeNode;
        int depth;
        QueueNode(TreeNode treeNode, int depth){
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}
