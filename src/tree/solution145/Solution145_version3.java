package tree.solution145;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历，
 * Morris版本，特点：
 * O(n)时间复杂度，
 * O(1)空间复杂度，利用已经存在的树指针
 * @author Billion
 * @create 2021-05-04 23:27
 */
public class Solution145_version3 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		//两个辅助指针
		TreeNode p1 = root; //表示当前节点
		TreeNode p2 = null; //表示当前节点的左节点
		while(p1 != null){//当前节点为空，表示遍历完毕
			p2 = p1.left;
			//当前节点存在左子树时，去寻找当前节点在中序遍历下的前驱节点，
			//当不存在左子树时，去访问当前节点右子树
			if(p2 != null){
				//寻找前驱节点，即：当前节点左子树中的最右节点
				while (p2.right != null && p2.right != p1){
					p2 = p2.right;
				}
				//此时要么p2.right == null，要么p2.right == p1
				if(p2.right == null){//此时表明第一次访问前驱节点，
					//令前驱节点指向当前节点
					p2.right = p1;
					//继续向左下访问
					p1 = p1.left;
					continue;
				}else{//p2.right == p1，
					//此时应当还原指针
					p2.right = null;
					// 表明第二次访问到当前节点，逆序输出从当前节点的左节点到前驱节点的序列
					res.addAll(addPath(p1.left));
				}
			}
			p1 = p1.right;
		}
		//最终循环结束，从root节点开始的最右路径没有访问
		res.addAll(addPath(root));
		return res;
	}

	//逆序输出从指定节点到最右子节点的序列
	List<Integer> addPath(TreeNode node){
		LinkedList<Integer> res = new LinkedList<>();
		while(node != null){
			res.addFirst(node.val);
			node = node.right;
		}
		return res;
	}
}
