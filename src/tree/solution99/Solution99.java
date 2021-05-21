package tree.solution99;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 恢复二叉搜索树，version1 + version2
 * @author Billion
 * @create 2021/04/24 19:44
 */
public class Solution99 {
    //version1
    public void recoverTree_version1(TreeNode root) {
        //一栈
        Stack<TreeNode> st = new Stack<>();
        //一标志位
        boolean isVisited = false;
        //前一个遍历元素
        TreeNode ptr = new TreeNode(Integer.MIN_VALUE);
        //待交换数组
        List<TreeNode> swap = new ArrayList<>();
        if (root == null) {
            return;
        }else {
            st.push(root);
        }
        while(!st.isEmpty()){
            if(root.left != null && !isVisited){
                root = root.left;
                st.push(root);
            }else{
                if (root.val < ptr.val) {
                    swap.add(ptr);
                    swap.add(root);
                    if(swap.size() == 4){
                        break;
                    }
                }
                ptr = root;
                st.pop();
                if(root.right != null){
                    root = root.right;
                    st.push(root);
                    isVisited = false;
                }else if(!st.isEmpty()){
                    root = st.peek();
                    isVisited = true;
                }
            }
        }
        if(swap.size() == 2){
            int temp = swap.get(0).val;
            swap.get(0).val = swap.get(1).val;
            swap.get(1).val = temp;
        }else if(swap.size() == 4){
            int temp = swap.get(0).val;
            swap.get(0).val = swap.get(3).val;
            swap.get(3).val = temp;
        }
    }

    public void recoverTree_version2(TreeNode root) {
        //一栈
        Stack<TreeNode> st = new Stack<>();
        TreeNode ptr = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        List<TreeNode> swap = new ArrayList<>();
        while(!st.isEmpty() || ptr != null){
            while(ptr != null){
                st.push(ptr);
                ptr = ptr.left;
            }
            ptr = st.pop();
            if(ptr.val < prev.val){
                swap.add(prev);
                swap.add(ptr);
                if(swap.size() == 4){
                    break;
                }
            }
            prev = ptr;
            ptr = ptr.right;
        }
        if(swap.size() == 2){
            int tmp = swap.get(0).val;
            swap.get(0).val = swap.get(1).val;
            swap.get(1).val = tmp;
        }else if(swap.size() == 4){
            int tmp = swap.get(0).val;
            swap.get(0).val = swap.get(3).val;
            swap.get(3).val = tmp;
        }
    }
}
