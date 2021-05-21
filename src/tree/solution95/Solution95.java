package tree.solution95;

import tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 2
 * @author Billion
 * @create 2021/04/23 18:42
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            generateTreesWithLeftAndRight(i, leftList, rightList, list);
        }
        return list;
    }

    public void generateTreesWithLeftAndRight(
            int val, List<TreeNode> leftList, List<TreeNode> rightList, List<TreeNode> list) {
        for(TreeNode leftNode: leftList){
            for(TreeNode rightNode: rightList){
                TreeNode parentNode = new TreeNode(val, leftNode, rightNode);
                list.add(parentNode);
            }
        }
    }
}
