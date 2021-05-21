package tree.solution112;

import sun.util.resources.cldr.ebu.CurrencyNames_ebu;
import tree.entity.TreeNode;

/**
 * 二叉树路径之和
 * @author Billion
 * @create 2021/04/30 19:13
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int preSum, int targetSum) {
        if(root == null) return false;
        int currentSum = preSum + root.val;
        if(root.left == null && root.right == null)
            return currentSum == targetSum;
        return hasPathSum(root.left, currentSum, targetSum) || hasPathSum(root.right, currentSum, targetSum);
    }
}
