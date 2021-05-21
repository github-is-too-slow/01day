package tree.solution222;

import tree.entity.TreeNode;

/**
 * 完全二叉树的节点个数
 * 暴力解答不推荐
 * @author Billion
 * @create 2021/05/09 13:40
 */
public class Solution222 {
    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode prev = root;
        int depth = 1;
        while (prev.left != null){
            depth++;
            prev = prev.left;
        }
        if (depth == 1) return 1;
        countNodes(root, 1, depth);
        return (int) (Math.pow(2, depth -1)) + count - 1;
    }

    public boolean countNodes(TreeNode root, int depth, int treeDepth){
        if(depth == treeDepth -1){
            if(root.left != null && root.right != null){
                count += 2;
                return true;
            }else if(root.left != null || root.right != null){
                count++;
                return false;
            }else{
                return false;
            }
        }else {
            if(countNodes(root.left, depth + 1, treeDepth)){
                return countNodes(root.right, depth + 1, treeDepth);
            }else{
                return false;
            }
        }
    }
}
