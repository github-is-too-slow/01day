package tree.solution117;

import org.omg.CosNaming.NamingContextExtHelper;
import tree.entity.Node;

/**
 * @author Billion
 * @create 2021/05/03 20:16
 */
public class Solution117_version2 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node leftmost = root;
        Node nextLeftmost;
        //leftmost指向的层链表已建立完毕，判断是否叶子层
        while((nextLeftmost = nextLeftmost(leftmost)) != null){
            Node head = leftmost;
            while(head != null){
                Node nexthead = head.next;
                if(head.left != null){
                    if(head.right != null){
                        head.left.next = head.right;
                    }else{
                        while(nexthead != null){
                            if(nexthead.left != null){
                                head.left.next = nexthead.left;
                                break;
                            }else if(nexthead.right != null){
                                head.left.next = nexthead.right;
                                break;
                            }
                            nexthead = nexthead.next;
                        }
                    }
                }
                if(head.right != null){
                    while(nexthead != null){
                        if(nexthead.left != null){
                            head.right.next = nexthead.left;
                            break;
                        }else if(nexthead.right != null){
                            head.right.next = nexthead.right;
                            break;
                        }
                        nexthead = nexthead.next;
                    }
                }
                head = nexthead;
            }
            leftmost =  nextLeftmost;
        }
        return root;
    }

    Node nextLeftmost(Node node){
        while(node != null){
            if(node.left != null){
                return node.left;
            }
            if(node.right != null){
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}
