package tree.solution222;

import tree.entity.TreeNode;

/**
 * 完全二叉树的节点个数
 * 二分查找+位运算
 * @author Billion
 * @create 2021/05/20 21:42
 */
public class Solution222_version2 {
    public static void main(String[] args) {
        Solution222_version2 version2 = new Solution222_version2();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left = new TreeNode(4);
        right =  new TreeNode(5);
        root.left.left = left;
        root.left.right = right;
        root.right.left = new TreeNode(6);
        version2.countNodes(root);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //depth(root) = 0，先统计数的深度
        int depth = getDepth(root);
        //计算节点数范围
        int low = 1 << depth;
        int high = (1 << (depth + 1)) - 1;
        while(low < high){
            int middle = low + (high - low + 1) / 2;
            if(isExists(root, middle, depth)){
                low = middle;
            }else {
                high = middle - 1;
            }
        }
        return low;
    }

    /**
     * 判断一个节点编号值对应的节点是否存在
     * @param num代表节点编号
     * @param depth代表树深度
     * @return
     */
    public boolean isExists(TreeNode root, int num, int depth){
        int assist = 1 << (depth - 1);
        while(root != null && assist != 0){
            int res = num & assist;
            if(res == 0){
                root = root.left;
            }else{
                root = root.right;
            }
            assist = assist >> 1;
        }
        return root != null;
    }

    /**
     * 计算二叉树深度
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){
        int depth = 0;
        while(root.left != null){
            depth++;
            root = root.left;
        }
        return depth;
    }
}
