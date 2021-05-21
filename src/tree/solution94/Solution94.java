package tree.solution94;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历，version1 + version2（推荐）
 * @author Billion
 * @create 2021/04/22 10:00
 */
public class Solution94 {
    List<Integer> inorder = new ArrayList<>();

    //迭代中序遍历，version1
    //递归转迭代，关键：一栈一标志位
    public List<Integer> inorderTraversal_ite_version1(TreeNode root){
        //一栈
        Stack<TreeNode> st = new Stack<>();
        //一标志位
        boolean isVisited = false;
        if (root == null) {
            return inorder;
        }else {
            st.push(root);
        }
        while(!st.isEmpty()){
            //此时root元素已入栈
            if (root.left != null && !isVisited) {
                root = root.left;
                st.push(root);
            }else{
                //左子树已走到底，记录中序值并弹栈
                inorder.add(root.val);
                st.pop();
                if(root.right != null){
                    root = root.right;
                    st.push(root);
                    //标志右子节点的左子树未访问
                    isVisited = false;
                }else if(!st.isEmpty()){
                    root = st.peek();
                    //去栈顶元素意味着左子树已访问完毕
                    isVisited = true;
                }
            }
        }
        return inorder;
    }

    //迭代中序遍历，version2
    //只需一个栈，无需标志位
    public List<Integer> inorderTraversal_ite_version2(TreeNode root) {
        //一栈
        Stack<TreeNode> st = new Stack<>();
        TreeNode ptr = root;
        while(!st.isEmpty() || ptr != null){
            //ptr不为空，左子树必定没有访问
            //ptr为空的情况有：1.左子树为空，2.一个节点的所有左子树节点均访问完毕
            while(ptr != null){
                st.push(ptr);
                ptr = ptr.left;
            }
            //递归访问节点
            ptr = st.pop();
            inorder.add(ptr.val);
            //转向右子树
            ptr = ptr.right;
        }
        return inorder;
    }

    //递归中序遍历
    public List<Integer> inorderTraversal_rec(TreeNode root) {
        if (root == null) {
            return inorder;
        }
        this.inorderTraversal_rec(root.left);
        inorder.add(root.val);
        this.inorderTraversal_rec(root.right);
        return inorder;
    }
}
