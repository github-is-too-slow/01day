package tree.solution235;

import javafx.scene.shape.CullFace;
import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉搜索树的最近公共祖先
 * 版本1：两次遍历
 * 寻找方式：
 * 先寻找p的祖先链表，再寻找q的祖先链表
 * 最后从前往后寻找两个链表的最后一个相同元素，就是最近公共祖先
 * @author Billion
 * @create 2021/05/09 16:44
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> first = getPath(root, p);
        List<TreeNode> second = getPath(root, q);
        //寻找最近公共祖先
        int len = Math.min(first.size(), second.size());
        int i = 0;
        while (i < len){
            if (first.get(i).val != second.get(i).val) break;
            i++;
        }
        return first.get(i - 1);
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> res = new ArrayList<>();
        //迭代遍历搜索二叉树
        while(root != target){
            if(target.val < root.val){
                res.add(root);
                root = root.left;
            }else if(target.val > root.val){
                res.add(root);
                root = root.right;
            }else{

            }
        }
        res.add(root);
        return res;
    }
}
