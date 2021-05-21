package tree.solution145;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历，迭代版本
 * @author Billion
 * @create 2021-05-04 22:06
 */
public class Solution145_version2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();
		TreeNode current = root;
		TreeNode prev = null;
		while(!st.isEmpty() || current != null){
			//一直往左走，相当于遍历左子树
			while(current != null){
				st.push(current);
				current = current.left;
			}
			current = st.pop();
			//当当前节点右子树为空或者右子树已经遍历完毕，就可以遍历当前节点
			if(current.right == null || current.right == prev){
				ret.add(current.val);
				prev = current;
				//当前节点为根子树访问完毕，就应该访问栈中父节点或父节点的右子树
				current = null;
			}else {
				//当前节点不为空且右子树还没有访问
				st.push(current);
				current = current.right;
			}
		}
		return ret;
	}
}
