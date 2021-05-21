package tree.solution102;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历，将根节点与子树分开考虑，不推荐
 * 自顶向下、自左向右遍历
 * @author Billion
 * @create 2021/04/28 18:11
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集
        List<List<Integer>> ret = new ArrayList<>();
        //一队列
        Queue<TreeNode> queue = new LinkedList<>();
        //当前层节点数
        int currentCount = 0;
        int nextCount = 0;
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ret.add(list);
            if(root.left != null){
                queue.offer(root.left);
                nextCount += 1;
            }
            if(root.right != null){
                queue.offer(root.right);
                nextCount += 1;
            }
        }
        List<Integer> list = null;
        while(!queue.isEmpty()){
            //当前层访问完毕，访问下一层
            if(currentCount == 0){
                currentCount = nextCount;
                nextCount = 0;
                if(list != null){
                    ret.add(list);
                }
                list = new ArrayList<>();
            }
            //访问当前层
            currentCount -= 1;
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if(treeNode.left != null){
                queue.offer(treeNode.left);
                nextCount += 1;
            }
            if(treeNode.right != null){
                queue.offer(treeNode.right);
                nextCount += 1;
            }
        }
        if(list != null){
            ret.add(list);
        }
        return ret;
    }
}
