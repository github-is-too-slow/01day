package tree.solution337;

import tree.entity.TreeNode;

/**
 * 打家劫舍3
 * 关键在于：分析出每个节点均具有两个状态：一个是选中状态，一个是未选中状态
 * @author Billion
 * @create 2021/05/21 19:57
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = rob2(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * @param root
     * @return 返回以当前节点为根节点的子树中
     * 包含当前节点的最大盗窃金额和不包含当前节点的最大盗窃金额
     */
    public int[] rob2(TreeNode root){
        int[] res = {0, 0};
        if (root == null) {
             return res;
        }
        int[] left = rob2(root.left);
        int[] right = rob2(root.right);
        if(left[1] >= 0 && right[1] >= 0){
            res[0] = root.val + left[1] + right[1];
        }else if(left[1] >= 0 || right[1] >= 0){
            res[0] = root.val + Math.max(left[1], right[1]);
        }else {
            res[0] = root.val;
        }
        int leftMax = Math.max(left[0], left[1]);
        int rightMax = Math.max(right[0], right[1]);
        if(leftMax >= 0 && rightMax >= 0){
            res[1] = leftMax + rightMax;
        }else {
            res[1] = Math.max(leftMax, rightMax);
        }
        return res;
    }
}
