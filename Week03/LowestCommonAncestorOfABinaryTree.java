import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 二叉树的最近公共祖先
 * @date 2020/6/26
 */
public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){};
        public TreeNode(int _val){
            this.val = _val;
        }
    }
    // TO TEST
    public static void main(String[] args) {

    }

    /**
     * 思路没问题，但是题解不正确
     * 分析
     * 1、求p节点和q节点的最近的公共祖先；
     * 2、p节点本身，p的父节点，p的爷爷节点...，穷举出p的所有父节点（包含它本身），按照最近的顺序排序放入队列或者集合中；
     * 3、q节点本身，q的父节点，q的爷爷节点...，穷举出q的所有父节点（包含它本身），按照最近的顺序排序放入队列或者集合中；
     * 4、从头开始比较两个集合中第一个相同的数据，输出该值，即为最近的父节点
     *
     * 思路：
     * 1、参考上面2，3，4步骤
     * 2、重复子问题，不断的获取父节点，直到根节点
     * 3、问题时如何获取父节点？？？无法从叶子节点获取父节点，但是可以从父节点遍历获取叶子节点
     *
     * 复杂度分析
     *
     */
    public static TreeNode lowestCommonAncestorOfABinaryTree1(TreeNode root, TreeNode p, TreeNode q){
        //定义返回上的结果
        TreeNode result = null;
        //定义一个基本路径集合
        List<TreeNode> nodeList = new ArrayList<>();
        //定义p节点的路径集合
        List<TreeNode> pNodeList = new ArrayList<>();
        //定义q节点的路径集合
        List<TreeNode> qNodeList = new ArrayList<>();
        //定义一个标识
        Boolean isSuccess = false;
        //遍历p节点的路径
        pNodeList = _DFS(root, p, nodeList, pNodeList, isSuccess);
        nodeList.clear();
        isSuccess = false;
        //遍历q节点的路径
        qNodeList = _DFS(root, p, nodeList, qNodeList, isSuccess);
        //如果p与q有公共父节点，则两个节点的遍历路径肯定会有重复的节点，获取路径长度最短的
        if (pNodeList != null && pNodeList.size() > 0 && qNodeList != null && qNodeList.size() > 0) {
            int length = pNodeList.size() > qNodeList.size() ? qNodeList.size() : pNodeList.size();
            for (int i = 0; i < length; i++) {
                if (pNodeList.get(i).equals(qNodeList.get(i))) {
                    result = pNodeList.get(i);
                }
            }
        }
        return result;
    }

    private static List<TreeNode> _DFS(TreeNode root, TreeNode search, List<TreeNode> nodeList, List<TreeNode> searchNodeList,Boolean isSuccess) {

        //1、跳出递归的条件
        if (root == null || isSuccess){
            //如果根节点不存在或者已经找到，则直接返回
            return searchNodeList;
        }

        //2、将当前节点保存,处理当前层的逻辑
        nodeList.add(root);
        if (root.equals(search)){
            //如果当前节点与要查找的节点相同，则把nodeList的集合赋值给要查找的集合，同时设置状态值，并返回
            searchNodeList = nodeList;
            isSuccess = true;
        }

        //3、递归下一层
        //先遍历左子树
        _DFS(root.left, search, nodeList, searchNodeList, isSuccess);
        //遍历右子树
        _DFS(root.right, search, nodeList, searchNodeList, isSuccess);

        //4、若遍历完成左右子树都不存在,清除集合中添加的根节点
        nodeList.remove(root);
        return searchNodeList;

    }

    /**
     * 正确的递归题解
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestorOfABinaryTree2(TreeNode root, TreeNode p, TreeNode q){
        //跳出递归的条件
        if (root == null || root == p || root == q){
            return root;
        }
        //下探到下一层（采用分治的思想，分别遍历左子树和右子树）
        TreeNode left = lowestCommonAncestorOfABinaryTree2(root.left, p, q);
        TreeNode right = lowestCommonAncestorOfABinaryTree2(root.right, p, q);
        //返回值
        if (left == null && right != null){
            return right;
        }
        if (left != null && right == null){
            return left;
        }
        if (left != null && right != null){
            return root;
        }
        // 左右子节点都为null
        return null;
    }
}
