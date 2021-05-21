package tree.solution106;

import tree.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序和后序构造二叉树
 * 根据hashMap查找根元素的索引，并且对元素值的大小没有限制
 * @author Billion
 * @create 2021/04/29 22:19
 */
public class Solution106 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) throw new RuntimeException("中序和后序序列长度不相等");
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int instart, int inend,
                              int[] postorder, int poststart, int postend) {
        if(instart > inend) return null;
        int rootindex = map.get(postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = buildTree(inorder, instart, rootindex - 1,
                postorder,  poststart, rootindex + poststart - instart - 1);
        root.right = buildTree(inorder, rootindex + 1, inend,
                postorder, rootindex + poststart - instart, postend - 1);
        return root;
    }
}
