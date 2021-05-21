package tree.solution429;


import tree.solution429.entity.Node2;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的层次遍历，递归版
 * @author Billion
 * @create 2021-05-13 20:49
 */
public class Solution429_version2 {
	public List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> levelOrder(Node2 root) {
		if(root == null) return res;
		dfs(root, 0);
		return res;
	}

	public void dfs(Node2 root, int depth){
		if(root == null) return;
		if(depth == res.size()){
			res.add(new ArrayList<>());
		}
		res.get(depth).add(root.val);
		if(root.children != null){
			for (int i = 0; i < root.children.size(); i++) {
				dfs(root.children.get(i), depth + 1);
			}
		}
	}
}
