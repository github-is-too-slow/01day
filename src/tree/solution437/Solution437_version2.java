package tree.solution437;

import tree.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Billion
 * @create 2021/05/21 22:33
 */
public class Solution437_version2 {
    private int targetSum;
    private Map<Integer, Integer> state;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        state = new HashMap<>();
        //代表了从根节点的虚父节点的前缀和，
        //任何节点的前缀和与它的前缀和之差表示从根节点出发的路径和
        state.put(0, 1);
        return dfs(root, 0);
    }

    /**
     *
     * @param root
     * @param sum 父节点的前缀和
     * @return 以当前节点为根的子树中的每个节点，以其中每个节点为结尾的可能路径的数量
     */
    public int dfs(TreeNode root, int sum){
        if (root == null) {
            return 0;
        }
        //当前节点的前缀和
        int prefix = sum + root.val;
        int diff = prefix - targetSum;
        //以当前节点为结尾的满足条件的路径数量
        int res = state.getOrDefault(diff, 0);
        //去遍历两颗子树前，将当前节点的前缀和加入map
        state.put(prefix, state.getOrDefault(prefix, 0) + 1);
        //以左子树中节点为结尾的满足条件的路径数量加上res
        res += dfs(root.left, prefix);
        //以右子树中节点为结尾的满足条件的路径数量加上res
        res += dfs(root.right, prefix);
        //当前节点判读完毕，恢复状态，相当于后序遍历
        state.put(prefix, state.get(prefix) - 1);
        return res;
    }
}
