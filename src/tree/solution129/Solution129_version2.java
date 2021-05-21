package tree.solution129;

import tree.entity.TreeNode;

/**
 * 求根到叶子节点数字之和，
 * 在寻找叶子节点的同时就将数字和计算出来，同时有递归版和层次遍历版，此处只写递归版。
 * @author Billion
 * @create 2021/05/03 22:43
 */
public class Solution129_version2 {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
}
