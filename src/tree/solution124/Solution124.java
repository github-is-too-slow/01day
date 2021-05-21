package tree.solution124;

import tree.entity.TreeNode;

/**
 * 二叉树的最大路径和
 * 关键在于定义最大增益函数：
 * 以当前节点为根节点的子树中，从当前节点出发的一条路径的最大和。
 * 另外：路径的定义是指：从路径的头节点出发，这条路径上的节点只能出现一次。
 * 这就保证了最大路径和的路径一定是先上升若干节点，到达顶点后，在下降若干节点。
 * @author Billion
 * @create 2021/05/03 21:52
 */
public class Solution124 {
    //维护全局最大路径和
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 计算最大贡献和：从该节点出发的一条路径的最大和
     * @param root
     * @return
     */
    public int maxGain(TreeNode root){
        if (root == null) {
            return 0;
        }
        //计算左节点的最大贡献和，如为负值，则忽略，计为0，相当于左节点为空
        int leftMaxGain = Math.max(maxGain(root.left), 0);
        //计算左节点的最大贡献和，如为负值，则忽略，计为0
        int rightMaxGain = Math.max(maxGain(root.right), 0);
        //更新最大路径和，取决于左右节点和根节点
        maxSum = Math.max(leftMaxGain + rightMaxGain + root.val, maxSum);
        //最终返回的还是最大贡献值，始终是从该节点出发的最大路径和
        return Math.max(leftMaxGain, rightMaxGain) + root.val;
    }
}
