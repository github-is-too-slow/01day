package tree.solution116;

import tree.entity.Node;

/**
 * 填充节点的下一个右侧指针
 * 广度优先遍历，不同于层次遍历，空间复杂度O(1)，推荐
 * @author Billion
 * @create 2021/05/03 18:51
 */
public class Solution116_version2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //第一层节点next链表已经建立完毕
        Node leftmost = root;
        while(leftmost.left != null){//未到达叶子节点层，必须为下一层节点建立next链表
            Node head = leftmost;
            while(head != null){
                //第一类next指针
                head.left.next = head.right;
                //第二类next指针
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
