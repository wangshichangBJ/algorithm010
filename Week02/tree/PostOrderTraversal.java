package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 二叉树后序遍历 左子树 -> 右子树 -> 根节点
 * @date 2020/6/19
 */
public class PostOrderTraversal {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> lastOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        lastOrderRes(root, result);
        return result;
    }

    private List<Integer> lastOrderRes(TreeNode root, List<Integer> result){
        if (root != null){
            if (root.left != null){
                lastOrderRes(root.left,result);
            }
            if (root.right != null){
                lastOrderRes(root.right,result);
            }
            result.add(root.val);
        }
        return result;
    }
}
