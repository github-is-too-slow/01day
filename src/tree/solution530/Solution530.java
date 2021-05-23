package tree.solution530;

import tree.entity.TreeNode;

/**
 * 二叉搜索树的最小绝对值
 * @author Billion
 * @create 2021-05-23 22:17
 */
public class Solution530 {
	private TreeNode prev;
	private int min;
	public int getMinimumDifference(TreeNode root) {
		prev = null;
		min = Integer.MAX_VALUE;
		dfs(root);
		return min;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if(prev != null && (root.val - prev.val) < min){
			min = root.val - prev.val;
		}
		prev = root;
		dfs(root.right);
	}
}
