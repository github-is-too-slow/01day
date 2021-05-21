package tree.solution113;

import sun.util.resources.cldr.en.CurrencyNames_en;
import sun.util.resources.cldr.uk.CurrencyNames_uk;
import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求所有满足路径之和的路径
 * 深度优先遍历
 * @author Billion
 * @create 2021/04/30 19:27
 */
public class Solution113 {
    List<Integer> current = new ArrayList<>();
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, 0, targetSum);
        return ret;
    }

    public void pathSum(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        current.add(root.val);
        if(root.left == null && root.right == null && currentSum == targetSum){
            List<Integer> list = new ArrayList<>(current);
            ret.add(list);
        }
        pathSum(root.left, currentSum, targetSum);
        pathSum(root.right, currentSum, targetSum);
        current.remove(current.size() - 1);
    }

    class StackNode {
        TreeNode treeNode;
        int sum;
        StackNode(TreeNode treeNode, int sum){
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }
}
