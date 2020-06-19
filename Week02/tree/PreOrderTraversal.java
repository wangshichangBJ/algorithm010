package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 二叉树先序遍历:根节点->左节点树-右节点树
 * @date 2020/6/18
 */
public class PreOrderTraversal {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static List<Integer> firstOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        opertionRecursive(root,result);
        return result;
    }

    private static List<Integer> opertionRecursive(TreeNode root, List<Integer> result){
        if (root != null){
            result.add(root.val);
            if (root.left != null){
                opertionRecursive(root.left,result);
            }
            if (root.right != null){
                opertionRecursive(root.right,result);
            }
        }
        return result;
    }
}
