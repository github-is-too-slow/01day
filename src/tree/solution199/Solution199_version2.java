package tree.solution199;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树右视图，
 * 版本2：深度优先遍历
 * @author Billion
 * @create 2021/05/09 13:21
 */
public class Solution199_version2 {
    private List<Integer> res = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    /**
     *
     * @param root
     * @param depth 深度depth表明当前节点的深度，从0开始计算
     */
    public void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(depth == res.size()){//表明当前节点是该层第一个被访问的到的节点
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
