package tree.solution144;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历二叉树，迭代版本
 * @author Billion
 * @create 2021/05/03 23:27
 */
public class Solution144_version2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode ptr = root;
        while (!st.isEmpty() || ptr != null){
            while(ptr != null){
                //前序visit
                ret.add(ptr.val);
                //入栈以访问右子树
                st.push(ptr);
                //往下走
                ptr = ptr.left;
            }
            //ptr为空，一种可能往左已经走到底，一种可能左子树已经访问完毕
            ptr = st.pop().right;
        }
        return ret;
    }
}
