package tree.solution538;

import tree.entity.TreeNode;

/**
 * 二叉搜索树转化为累加树
 * 策略：中序遍历，但是顺序为：右子树-->根节点-->左子树
 * @author Billion
 * @create 2021-05-23 22:34
 */
public class Solution538 {
	private int sum;
	public TreeNode convertBST(TreeNode root) {
		if(root != null){
			convertBST(root.right);
			sum += root.val;
			root.val = sum;
			convertBST(root.left);
		}
		return root;
	}
}
