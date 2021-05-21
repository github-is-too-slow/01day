package tree.solution297;

import tree.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化与反序列化
 * 策略：递归先序遍历
 * 另外：可以采用（）+ 递归后序遍历编码和解码，设计编译原理知识，此处省略
 * @author Billion
 * @create 2021/05/21 0:11
 */
public class Codec_version2 {
    // Encodes a tree to a single string.
    //先序遍历，编码形式如：val,code(left),code(right)
    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    /**
     * 在已有编码串上追加
     * @param root
     * @param str
     * @return
     */
    public String serialize(TreeNode root, String str){
        if (root == null) {
            str += "null,";
            return str;
        }
        str += root.val + ",";
        str = serialize(root.left, str);
        str = serialize(root.right, str);
        return str;
    }
    // Decodes your encoded data to tree.
    //解码形如：1,2,3,null,null,4,null,null,5,null,null
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(strs));
        return deserialize2(dataList);
    }

    public TreeNode deserialize2(List<String> dataList) {
        if(dataList.get(0).equals("null")){
            //当前节点为空树
            dataList.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        cur.left = deserialize2(dataList);
        cur.right = deserialize2(dataList);
        return cur;
    }


}
