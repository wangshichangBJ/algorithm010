import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 二叉树层序遍历
 * 多叉树的层序遍历，只需要不断获取其子节点，不需要区分左右子节点
 * @date 2020/7/23
 */
public class LevelOrder {

    public class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int _val, TreeNode _left, TreeNode _right) {
            this.val = _val;
            this.left = _left;
            this.right = _right;
        }

    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        //构建结果集
        List<List<Integer>> result = new ArrayList<>();
        //构建双端队列，作为临时存储容器
        Deque<TreeNode> dq = new ArrayDeque<>();
        //边界条件判断
        if (root == null) {
            return result;
        }
        //将根节点添加到双端队列中
        dq.add(root);

        //遍历双端队列，直到队列为空
        while (!dq.isEmpty()) {
            //创建子元素集合
            List<Integer> sonResult = new ArrayList<>();
            //逐层遍历
            for (int i = 0; i < dq.size(); i++ ) {
                //从队列中获取头结点，并删除头结点
                TreeNode node = dq.poll();
                sonResult.add(node.val);
                if (node.left != null) {
                    dq.add(node.left);
                }
                if (node.right != null) {
                    dq.add(node.right);
                }
            }
            result.add(sonResult);
        }
        return result;
    }

    /**
     * 多叉树
     */
    public class Node {
        public int val;
        Node children;

        Node(int _val, Node _children) {
            this.val = _val;
            this.children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> dq = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        dq.add(root);

        while (!dq.isEmpty()) {
            List<Integer> sonResult = new ArrayList<>();

            for (int i = 0; i < dq.size(); i++) {
                Node node = dq.poll();
                sonResult.add(node.val);
                if (node.children != null ) {
                    dq.add(node.children);
                }
            }
            result.add(sonResult);
        }
    return result;
    }

}
