package tree.solution105;

import tree.entity.TreeNode;

/**
 * 前序和中序构造二叉树
 * @author Billion
 * @create 2021/04/29 21:05
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length -1,
                inorder, 0, inorder.length -1);
    }

    public TreeNode buildTree(int[] preorder, int prestart, int preend,
                              int[] inorder, int instart, int inend) {
        if(prestart > preend || instart > inend){
            return null;
        }
        int rootIndex = search(inorder, instart, inend, preorder[prestart]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildTree(preorder, prestart + 1, rootIndex + prestart - instart,
                inorder, instart, rootIndex -1);
        root.right = buildTree(preorder, rootIndex + prestart - instart + 1, preend,
                inorder, rootIndex + 1, inend);
        return root;
    }


    //寻找root节点在中序序列中的索引，
    //version2:可以将中序序列放入hashmap中，key为元素值，value为元素索引
    public int search(int[] order, int start, int end, int key){
        for (int i = start; i <= end; i++) {
            if(order[i] == key) return i;
        }
        return -1;
    }
}
