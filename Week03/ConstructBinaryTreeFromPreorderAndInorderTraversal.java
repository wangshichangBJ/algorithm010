import java.util.HashMap;
import java.util.Map;

/**
 * @author ShiChang Wang
 * @description 构建二叉树
 * @date 2020/6/26
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // TO TEST
    public static void main(String[] args) {

    }

    /**
     * 分析
     * 1、前序遍历（根 左 右）
     * 2、中序遍历（左 根 右）
     *
     * 思路
     * 1、前序遍历的第一个节点为根节点
     * 2、根据根节点的值，从中序遍历中获取根节点，然后以根节点为分界点，向左为左子树的节点，向右为右子树的节点
     * 3、通过递归，不断的设置各个子树的根节点，然后构造二叉树。
     * 4、分别递归构建左子树和右子树
     *
     * 复杂度分析
     *
     */
    public static TreeNode constructBinaryTreeFromPreorderAndInorderTraversal(int[] preorder, int[] inorder){
        //遍历中序遍历数组，将值与索引存储在map集合中
        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i],i);
        }
        TreeNode treeNode = buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, inOrderMap);
        return treeNode;
    }

    private static TreeNode buildTree(int[] preorder, int preStartIndex, int preEndIndex,
                                      int[] inorder, int inStartIndex, int inEndIndex, Map<Integer,Integer> inOrderMap) {
        if (preStartIndex == preEndIndex){
            //放置数组越界
            return null;
        }
        //获取根节点
        int rootVal = preorder[preStartIndex];
        TreeNode root = new TreeNode(rootVal);
        //获取根节点在中序遍历数组中的下标索引值
        Integer rootIndex = inOrderMap.get(rootVal);
        //获取左子树的长度
        int leftLength = rootIndex - inStartIndex;
        //递归构建左子树
        /**
         * preorder 前序遍历
         * preStartIndex + 1 前序遍历中左子树的起始下标
         * preStartIndex + leftLength + 1 前序遍历中左子树的结束下标
         * inorder 中序遍历
         * inStartIndex 中序遍历的左子树起始下标
         * rootIndex 中序遍历的左子树结束下标
         */
        root.left = buildTree(preorder, preStartIndex + 1,preStartIndex + leftLength + 1, inorder, inStartIndex, rootIndex, inOrderMap);
        root.right = buildTree(preorder, preStartIndex + leftLength + 1, preEndIndex, inorder, rootIndex + 1, inEndIndex, inOrderMap);
        return root;

    }
}
