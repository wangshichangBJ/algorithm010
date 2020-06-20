package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ShiChang Wang
 * @description N叉树的层序遍历
 * 根 儿子辈（左到右） 孙子节点（左到右）......
 * @date 2020/6/20
 */
public class Levelorder {

    public class Node{
        int val;
        List<Node> children;

        public Node(int _val, List<Node> _children){
            this.val = _val;
            this.children = _children;
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> childResult = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i< size; i++){
                Node node = queue.remove();
                childResult.add(node.val);
                queue.addAll(node.children);
            }
            result.add(childResult);
        }
        return result;
    }
}
