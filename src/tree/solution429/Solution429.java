package tree.solution429;


import tree.solution429.entity.Node2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树层次遍历，迭代版
 * @author Billion
 * @create 2021-05-11 22:18
 */
public class Solution429 {
	public List<List<Integer>> levelOrder(Node2 root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<Node2> queue = new LinkedList<>();
		if (root == null) return res;
		queue.offer(root);
		List<Node2> children;
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				children = root.children;
				level.add(root.val);
				queue.addAll(children);
//				if(children != null){
//					for (int j = 0; j < children.size(); j++) {
//						queue.offer(children.get(j));
//					}
//				}
			}
			res.add(level);
		}
		return res;
	}
}
