package tree.solution515;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求每个树行中的最大值
 * 迭代层次遍历很简单，这里采用递归策略
 * @author Billion
 * @create 2021-05-22 22:17
 */
public class Solution515 {
	private List<Integer> res;
	public List<Integer> largestValues(TreeNode root) {
		res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(root, 0);
		return res;
	}

	public void dfs(TreeNode root, int depth){
		if (root == null) {
			return;
		}
		if(depth == res.size()){//所在行的一个元素，直接进队
			res.add(root.val);
		}else if(root.val > res.get(depth)) {
			res.set(depth, root.val);
		}
		dfs(root.left, depth + 1);
		dfs(root.right, depth + 1);
	}
}
