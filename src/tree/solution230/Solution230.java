package tree.solution230;

import tree.entity.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树中第K小元素，迭代遍历
 * @author Billion
 * @create 2021/05/09 16:30
 */
public class Solution230 {
    //1 <= k <= n
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while (!st.isEmpty() || current != null){
            while(current != null){
                st.push(current);
                current = current.left;
            }
            //中序访问
            current = st.pop();
            if(k == 1) return current.val;
            k--;
            current = current.right;
        }
        return -1;
    }
}
