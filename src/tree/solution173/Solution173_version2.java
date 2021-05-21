package tree.solution173;


import tree.entity.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的迭代器，
 * 版本2：无需提前遍历完二叉树，而是动态获取下一个节点,
 * 其实就是将 二叉搜索树的迭代版本的代码 拆分成next()函数和hasNext()函数
 * @author Billion
 * @create 2021-05-13 21:43
 */
public class Solution173_version2 {
	private TreeNode current;
	private Stack<TreeNode> st;

	public Solution173_version2(TreeNode root) {
		current = root;
		st = new Stack<>();
	}

	public int next() {
		//假设总是存在下一个节点
		while(current != null){
			st.push(current);
			current = current.left;
		}
		//找到了下一个节点
		current = st.pop();
		int val = current.val;
		//继续向右子树中寻找下一个节点
		current = current.right;
		return val;
	}

	public boolean hasNext() {
		//当栈非空或current指向节点不空时，表明有下一个节点
		return !st.isEmpty() || current != null;
	}
}
