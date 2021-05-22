package tree.solution450;

import tree.entity.TreeNode;

/**
 * 删除二叉搜索树BST中的节点
 * @author Billion
 * @create 2021/05/22 12:04
 */
public class Solution450 {

    /**
     * 第一步：寻找节点
     * 第二步：删除节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }else {
            //删除当前节点
            if(root.left != null && root.right != null){
                //寻找当前节点的中序后继节点，即右子树中最左子节点
                TreeNode prev = root;
                TreeNode next = root.right;
                while(next.left != null){
                    prev = next;
                    next = next.left;
                }
                //先删除最左子节点
                if(prev == root){
                    prev.right = next.right;
                }else {
                    prev.left = next.right;
                }
                //再删除当前节点
                root.val = next.val;
            }else if(root.left == null){
                return root.right;
            }else {
                return root.left;
            }
        }
        return root;
    }
}
