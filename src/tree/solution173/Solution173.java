package tree.solution173;

import tree.entity.TreeNode;


/**
 * 二叉搜索树迭代器
 * @author Billion
 * @create 2021/05/06 22:16
 */
public class Solution173 {
    private TreeNode current;
    private TreeNode prev;
    private TreeNode root;

    public Solution173(TreeNode root) {
        this.root = root;
        current = new TreeNode(-1);

    }

    //假设总有下一个
    public int next(){
        return 0;
    }

    private TreeNode search(TreeNode root){
        if(root == null) return null;
        if(current.val < root.val){
            return search(root.left);
        }else if(current.val > root.val){
            return search(root.right);
        }else{
            return root;
        }
    }

    public boolean hasNext() {
        if(root == null) return false;
        TreeNode prev = root;
        while(prev.right != null) prev = prev.right;
        if(prev == current) return false;
        return true;
    }
}
