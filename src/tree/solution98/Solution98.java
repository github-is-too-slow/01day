package tree.solution98;

import tree.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证二叉搜索树
 * @author Billion
 * @create 2021/04/23 19:33
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return findMaxAndMin(root).get("isValid") == 1;
    }

    public Map<String, Integer> findMaxAndMin(TreeNode root){
        Map<String, Integer> ret = new HashMap<>();
        Map<String, Integer> leftRet;
        Map<String, Integer> rightRet;
        if (root.left == null) {
            leftRet = new HashMap<>();
            leftRet.put("max", Integer.MIN_VALUE);
            leftRet.put("min", root.val);
            leftRet.put("isValid", 1);
        }else{
            leftRet = findMaxAndMin(root.left);
        }
        if(root.right == null){
            rightRet = new HashMap<>();
            rightRet.put("max", root.val);
            rightRet.put("min", Integer.MAX_VALUE);
            rightRet.put("isValid", 1);
        }else {
            rightRet = findMaxAndMin(root.right);
        }
        boolean isValid = true;
        if(root.left == null && root.val == Integer.MIN_VALUE){
        }else {
            isValid = leftRet.get("isValid") ==1 && leftRet.get("max") < root.val;
        }
        if(root.right == null && root.val == Integer.MAX_VALUE){
        }else {
            isValid = isValid && rightRet.get("isValid") == 1 && rightRet.get("min") > root.val;
        }
        if(isValid){
            ret.put("max", rightRet.get("max"));
            ret.put("min", leftRet.get("min"));
            ret.put("isValid", 1);
        }else{
            ret.put("isValid", 0);
        }
        return ret;
    }
}
