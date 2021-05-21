package tree.solution116;

import tree.entity.Node;

/**
 * 填充节点的下一个右侧节点指针
 * 递归前序遍历
 * @author Billion
 * @create 2021/05/03 19:00
 */
public class Solution116_version3 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if(root.left != null){
            //建立第一类next指针
            root.left.next = root.right;
        }
        if(root.next != null && root.right != null){
            //建立第二类next指针
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
