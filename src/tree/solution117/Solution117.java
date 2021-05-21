package tree.solution117;

import tree.entity.Node;

/**
 * 填充节点的下一个右侧节点指针
 * 递归遍历，该做法有问题，无法解决：
 * 输入：[1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 错误输出：[1,#,2,3,#,4,5,6,#,7,#]
 * 预期输出：[1,#,2,3,#,4,5,6,#,7,8,#]
 * @author Billion
 * @create 2021/05/03 19:47
 */
public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //为左节点建立连接
        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }else if(root.next != null){
                if(root.next.left != null){
                    root.left.next = root.next.left;
                }else if(root.next.right != null){
                    root.left.next = root.next.right;
                }
            }
        }
        //为右节点建立连接
        if(root.right != null){
            if(root.next != null){
                if(root.next.left != null){
                    root.right.next = root.next.left;
                }else if(root.next.right != null){
                    root.right.next = root.next.right;
                }
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
