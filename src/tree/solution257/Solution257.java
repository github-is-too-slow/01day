package tree.solution257;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树所有路径
 * ["1->2->5", "1->3"]
 * @author Billion
 * @create 2021/05/09 21:56
 */
public class Solution257 {
    private List<String> res = new ArrayList<>();
    private List<TreeNode> tmp = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root == null) return;
        tmp.add(root);
        if(root.left == null && root.right == null) res.add(output());
        dfs(root.left);
        dfs(root.right);
        tmp.remove(tmp.size() - 1);
    }

    public String output(){
        StringBuilder sb = new StringBuilder();
        int len = tmp.size();
        for (int i = 0; i < len - 1; i++) {
            sb.append(tmp.get(i).val+ "->");
        }
        sb.append(tmp.get(len - 1).val);
        return sb.toString();
    }
}
