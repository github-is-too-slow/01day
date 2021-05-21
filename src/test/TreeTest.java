package test;

import org.junit.Test;
import tree.solution94.Solution94;
import tree.solution96.Solution96;

import javax.lang.model.SourceVersion;
import javax.swing.tree.TreeNode;

/**
 * @author Billion
 * @create 2021/04/22 10:15
 */
public class TreeTest {
    @Test
    public void test96(){
        Solution96 solution96 = new Solution96();
        int count = solution96.numTrees(3);
        System.out.println(count);
    }
}
