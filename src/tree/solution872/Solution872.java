package tree.solution872;


import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 叶子相似的树
 * @author Billion
 * @create 2021-05-10 21:50
 */
public class Solution872 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		//此时root1和root2必不为空
		queue1.offer(root1);
		queue2.offer(root2);
		while(!queue1.isEmpty() && !queue2.isEmpty()){
			while(!queue1.isEmpty()){
				root1 = queue1.poll();
				if(root1.left == null && root1.right == null) break;
				if(root1.left != null) queue1.offer(root1.left);
				if(root1.right != null) queue1.offer(root1.right);
			}
			while(!queue2.isEmpty()){
				root2 = queue2.poll();
				//判断与树1的当前叶子节点是否相等
				if(root2.left == null && root2.right == null){
					if(root1.val != root2.val) return false;
					else break;
				}
				if(root2.left != null) queue2.offer(root2.left);
				if(root2.right != null) queue2.offer(root2.right);

			}
		}
		while(!queue1.isEmpty()){
			root1 = queue1.poll();
			if(root1.left == null && root1.right == null) return false;
			if(root1.left != null) queue1.offer(root1.left);
			if(root1.right != null) queue1.offer(root1.right);
		}
		while(!queue2.isEmpty()){
			root2 = queue2.poll();
			if(root2.left == null && root2.right == null) return false;
			if(root2.left != null) queue2.offer(root2.left);
			if(root2.right != null) queue2.offer(root2.right);
		}
		return true;
	}
}
