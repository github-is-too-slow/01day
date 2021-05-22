package tree.solution508;

import tree.entity.TreeNode;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * 出现次数最多的子树元素和
 * @author Billion
 * @create 2021-05-22 21:16
 */
public class Solution508 {
	private Map<Integer, Integer> sums;
	public int[] findFrequentTreeSum(TreeNode root) {
		sums = new HashMap<>();
		dfs(root);
		int max = 0;
		List<Integer> res = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry: sums.entrySet()){
			Integer cur = entry.getValue();
			if(cur > max){
				max = cur;
				res.clear();
				res.add(entry.getKey());
			}else if(cur == max){
				res.add(entry.getKey());
			}
		}
		int[] ints = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ints[i] = res.get(i);
		}
		return ints;
	}

	public int dfs(TreeNode root){
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		int sum = left + right + root.val;
		sums.put(sum, sums.getOrDefault(sum, 0) + 1);
		return sum;
	}
}
