package tree.solution116;

import tree.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充节点下一个右侧节点指针
 * 版本1：层次遍历，空间复杂度O(N)，不推荐
 * @author Billion
 * @create 2021/05/03 18:03
 */
public class Solution116 {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                Node node = queue.poll();
                node.next = queue.peek();
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
        }
        return root;
    }
}
