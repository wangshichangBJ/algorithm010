package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 二叉树中序遍历 左子树->根节点->右子树
 * @date 2020/6/18
 */
public class InOrderTraversal {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inOrderRes(root,result);
        return result;
    }

    private List<Integer> inOrderRes(TreeNode root, List<Integer> result){
        if (root != null){
            if (root.left != null){

            }
        }
        return result;
    }

}
