package tree.solution449;

import tree.entity.TreeNode;

/**
 * 二叉搜索树BST的序列化和反序列化
 * 编码时只需要前序遍历序列便可以重构BST，
 * 因为二叉搜索树中序遍历有序
 * @author Billion
 * @create 2021/05/22 11:09
 */
public class Solution449 {
    //编码缓冲区
    private StringBuilder sb;
    //当前解码索引(编码字符串转化后的数组）
    private int cur;

    // Encodes a tree to a single string.
    //前序遍历序列格式如：5,3,2,4,9.6,12,
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serialize2(root);
        return sb.toString();
    }

    public void serialize2(TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        serialize2(root.left);
        serialize2(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] dataList = data.split(",");
        //初始化索引
        cur = 0;
        return deserialize2(dataList, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //将前序遍历序列格式如：5,3,2,4,9.6,12,的字符串解析为BST，
    //注意这里跟解析一般二叉树前序遍历序列不同，因为它没有加入空节点标志null,
    //因此这里利用BST特性：每颗BST的根节点满足min =< root.val =< max
    public TreeNode deserialize2(String[] dataList, int min, int max) {
        if (cur >= dataList.length) return null;
        int curValue = Integer.parseInt(dataList[cur]);
        if(curValue < min || curValue > max) return null;
        TreeNode root = new TreeNode(curValue);
        cur++;
        root.left = deserialize2(dataList, min, curValue);
        root.right =  deserialize2(dataList, curValue, max);
        return root;
    }
}
