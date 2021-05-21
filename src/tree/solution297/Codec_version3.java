package tree.solution297;

import tree.entity.TreeNode;

/**
 * 序列化和反序列化
 * 通过StringBuilder降低时间复杂度
 * @author Billion
 * @create 2021/05/21 19:06
 */
public class Codec_version3 {
    private StringBuilder sb;
    private int cur;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serialize2(root);
        return sb.toString();
    }

    //编码格式：1,2,3,null,null,4,null,null,5,null,null
    public void serialize2(TreeNode root){
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serialize2(root.left);
        serialize2(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        cur = 0;
        String[] dataList = data.split(",");
        return deserialize2(dataList);
    }

    public TreeNode deserialize2(String[] dataList) {
        if(dataList[cur].equals("null")){
            cur++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList[cur++]));
        root.left = deserialize2(dataList);
        root.right = deserialize2(dataList);
        return root;
    }
}
