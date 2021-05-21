package tree.solution297;

import jdk.nashorn.internal.parser.JSONParser;
import org.omg.CORBA.RepositoryIdHelper;
import sun.reflect.generics.tree.Tree;
import sun.util.resources.cldr.en.CurrencyNames_en;
import tree.entity.TreeNode;

import java.util.*;

/**
 * 二叉树序列化和反序列化
 * [1,2,3,null,null,4,5]
 * @author Billion
 * @create 2021/05/09 22:42
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.add(root.val);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                res.add(current.left.val);
                queue.offer(current.left);
            }else {
                res.add(null);
            }
            if(current.right != null){
                res.add(current.right.val);
                queue.offer(current.right);
            }else {
                res.add(null);
            }
        }
        int i = res.size() - 1;
        for (; i >= 0 ; i--) {
            if(res.get(i) != null) break;
        }
        return res.subList(0, i + 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)) return null;
        data = data.substring(1);
        data = data.substring(0, data.length() - 1);
        List<String> list = Arrays.asList(data.split(","));
        TreeNode res = new TreeNode(Integer.parseInt(list.get(0).trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(res);
        int i = 1;
        while(i < list.size()){
            TreeNode treeNode = queue.poll();
            if(!"null".equals(list.get(i).trim())){
                TreeNode left = new TreeNode(Integer.parseInt(list.get(i).trim()));
                treeNode.left = left;
                queue.offer(left);
            }
            i++;
            if(i < list.size() && !"null".equals(list.get(i).trim())){
                TreeNode right = new TreeNode(Integer.parseInt(list.get(i).trim()));
                treeNode.right = right;
                queue.offer(right);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left = new TreeNode(4);
        right = new TreeNode(5);
        root.right.left = left;
        root.right.right = right;
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        String data = codec.serialize(root);
        if("[]".equals(data)) return;
        data = data.substring(1);
        data = data.substring(0, data.length() - 1);
        List<String> list = Arrays.asList(data.split(","));
        TreeNode res = new TreeNode(Integer.parseInt(list.get(0).trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(res);
        int i = 1;
        while(i < list.size()){
            TreeNode treeNode = queue.poll();
            if(!"null".equals(list.get(i).trim())){
                TreeNode left1 = new TreeNode(Integer.parseInt(list.get(i).trim()));
                treeNode.left = left1;
                queue.offer(left1);
            }
            i++;
            if(!"null".equals(list.get(i).trim())){
                TreeNode right1 = new TreeNode(Integer.parseInt(list.get(i).trim()));
                treeNode.right = right1;
                queue.offer(right1);
            }
            i++;
        }
        output(res);
    }

    public static void output(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        output(root.left);
        output(root.right);
    }
}