package tree.solution144;

import tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历，
 * Morris版本，
 * 特点：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author Billion
 * @create 2021/05/06 21:26
 */
public class Solution144_version3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Morris迭代遍历，最重要的是利用已经存在的right指针
        List<Integer> res = new LinkedList<>();
        //两个辅助指针
        TreeNode p1 = root; //代表当前节点
        TreeNode p2 = null;
        while(p1 != null){
            p2 = p1.left;
            //当前节点的左节点不为空则寻找当前节点在左子树中的中序前驱节点
            if(p2 != null){
                //寻找前驱节点
                while(p2.right != null && p2.right != p1){
                    p2 = p2.right;
                }
                //此时要么p2.right == null 要么p2.right == p1
                if(p2.right == null){
                    //此时表明第一次访问到当前节点，可以直接访问当前节点
                    res.add(p1.val);
                    //并将前驱节点指向当前节点
                    p2.right = p1;
                    //更新当前节点为当前节点的左节点
                    p1 = p1.left;
                    continue;
                }else{
                    //此时p2.right == p1，表明第二次访问到当前节点，应该去访问当前节点的右节点，
                    //并还原指针
                    p2.right = null;
                    p1 = p1.right;
                }
            }else{
                //当前节点的左节点为空时，也应当先访问当前节点，在更新当前节点为当前节点的右节点
                res.add(p1.val);
                p1 = p1.right;
            }
        }
        return res;
    }
}
