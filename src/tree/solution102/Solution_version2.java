package tree.solution102;

import sun.reflect.generics.tree.Tree;
import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历，将根节点与子树统一考虑，推荐
 * 自顶向下、自左向右遍历
 * @author Billion
 * @create 2021/04/28 19:21
 */
public class Solution_version2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        //根节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //套两层循环时，外层循环检测当前队列中的元素必定在同一层，这才是核心
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
