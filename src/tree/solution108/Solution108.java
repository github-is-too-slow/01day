package tree.solution108;

import tree.entity.TreeNode;

/**
 * 将有序数组转化为BST
 * @author Billion
 * @create 2021/04/30 16:47
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if(start > end) return null;
        int size = end - start + 1;
        int rootindex = start + size / 2;
        TreeNode root = new TreeNode(nums[rootindex]);
        root.left = sortedArrayToBST(nums, start, rootindex - 1);
        root.right = sortedArrayToBST(nums, rootindex + 1, end);
        return root;
    }
}
