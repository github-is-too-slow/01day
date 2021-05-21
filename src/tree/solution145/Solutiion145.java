package tree.solution145;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后序遍历，递归版本
 * @author Billion
 * @create 2021-05-04 21:42
 */
public class Solutiion145 {
	List<Integer> ret = new LinkedList<>();

	public List<Integer> postorderTraversal(TreeNode root) {
		postorder(root);
		return ret;
	}

	void postorder(TreeNode treeNode){
		if (treeNode == null) {
			return;
		}
		postorder(treeNode.left);
		postorder(treeNode.right);
		ret.add(treeNode.val);
	}
}
