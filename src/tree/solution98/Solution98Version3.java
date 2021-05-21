package tree.solution98;

import tree.entity.TreeNode;

import java.util.Stack;

/**
 * 迭代中序遍历
 * @author Billion
 * @create 2021/04/24 15:45
 */
public class Solution98Version3 {
    public boolean isValidBST(TreeNode root) {
        //一栈
        Stack<TreeNode> st = new Stack<>();
        //当前最小值
        long min = Long.MIN_VALUE;
        TreeNode ptr = root;
        while(!st.isEmpty() || ptr != null){
            while(ptr != null){
                st.push(ptr);
                ptr = ptr.left;
            }
            ptr = st.pop();
            if(ptr.val <= min){
                return false;
            }
            min = ptr.val;
            ptr = ptr.right;
        }
        return true;
    }
}
