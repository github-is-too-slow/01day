package tree.solution96;

/**
 * 不同的二叉搜索树 1
 * @author Billion
 * @create 2021/04/22 21:41
 */
public class Solution96 {
    private int[] arr;

    public void init(int n){
        this.arr = new int[n];
    }

    public int countTrees(int n){
        //n == 0
        if(n == 0 || n == 1){
            return 1;
        }
        int count= 0;
        //n >= 1
        for (int i = 0; i < n; i++) {
            int left;
            int right;
            if(this.arr[i] > 0){
                left = this.arr[i];
            }else {
                left = this.countTrees(i);
                this.arr[i] = left;
            }
            if(this.arr[n - i - 1] > 0){
                right = this.arr[n - i - 1];
            }else {
                right = this.countTrees(n - i - 1);
                this.arr[n - i - 1] = right;
            }
            count += left * right;
        }
        return count;
    }
    public int numTrees(int n) {
        this.init(n);
        return this.countTrees(n);
    }
}
