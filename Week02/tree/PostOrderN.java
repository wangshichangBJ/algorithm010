package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description N叉树的前序遍历
 * 根节点 -> 子节点
 * @date 2020/6/19
 */
public class PostOrderN {
    public class Node {
        public int val;
        //子节点的集合
        public List<Node> children;
        //构造器
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preOrder(Node root) {
        if(root == null){
            return result;
        }
        int s = root.children.size();
        for(int i = 0; i < s; i++){
            preOrder(root.children.get(i));
        }
        result.add(root.val);
        return result;
    }
}
