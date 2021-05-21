package tree.solution404;


import tree.entity.TreeNode;

/**
 * 左叶子之和
 * @author Billion
 * @create 2021-05-10 22:34
 */
public class Solution404 {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if(root.left != null && root.left.left == null && root.left.right == null){
			return root.left.val + sumOfLeftLeaves(root.right);
		}
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}
