package tree.solution437;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和3
 * 本质：求二叉树中的所有路径
 * @author Billion
 * @create 2021/05/21 20:51
 */
public class Solution437 {
    private int count;
    private int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        this.targetSum = targetSum;
        dfs(root);
        return count;
    }

    public List<Integer> dfs(TreeNode root){
        if (root == null) {
            return null;
        }
        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
        List<Integer> res = merge(root, left, right);
        return res;
    }

    public List<Integer> merge(TreeNode root, List<Integer> left, List<Integer> right){
        List<Integer> res = new ArrayList<>();
        if(root.val == targetSum) count++;
        res.add(root.val);
        if (left != null) {
            for (int i = 0; i < left.size(); i++) {
                int sum = left.get(i) + root.val;
                if(sum == targetSum) count++;
                res.add(sum);
            }
        }
        if (right != null) {
            for (int i = 0; i < right.size(); i++) {
                int sum = right.get(i) + root.val;
                if(sum == targetSum) count++;
                res.add(sum);
            }
        }
        return res;
    }

}
