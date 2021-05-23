package tree.solution513;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值，即最后一行的第一个数
 * 层次遍历bfs
 * @author Billion
 * @create 2021-05-22 21:58
 */
public class Solution513 {
	public int findBottomLeftValue(TreeNode root) {
		int res = 0;
		//一队列
		Queue<TreeNode> queue = new LinkedList<>();
		//假设root不为空
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			root = queue.poll();
			if(root.left != null){
				queue.offer(root.left);
			}
			if(root.right != null){
				queue.offer(root.right);
			}
			res = root.val;
			for (int i = 0; i < size - 1; i++) {
				root = queue.poll();
				if(root.left != null){
					queue.offer(root.left);
				}
				if(root.right != null){
					queue.offer(root.right);
				}
			}
		}
		return res;
	}
}
