package tree.solution429.entity;

import java.util.List;

/**
 * @author Billion
 * @create 2021/05/21 20:41
 */
public class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }

}
