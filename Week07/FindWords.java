import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author ShiChang Wang
 * @description 单词搜索2
 * 自己没写出来，抄了一遍
 * @date 2020/7/26
 */
public class FindWords {

    /**
     * 定义字典树
     */
    public class wordTrie{
        public trieNode root=new trieNode();
        public void insert(String s){
            trieNode cur=root;
            for(char c:s.toCharArray()){
                if(cur.child[c-'a']==null) {
                    cur.child [c-'a'] = new trieNode();
                    cur=cur.child[c-'a'];
                } else {
                    cur = cur.child[c - 'a'];
                }
            }
            cur.isLeaf=true;
            cur.val=s;
        }
    }

    /**
     * 定义字典树
     */
    public class trieNode{
        public String val;
        public trieNode[] child=new trieNode[26];
        public boolean isLeaf=false;

        trieNode(){

        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        wordTrie myTrie = new wordTrie();
        trieNode root = myTrie.root;
        for(String s:words) {
            myTrie.insert(s);
        }

        //使用set防止重复，去重
        Set<String> result =new HashSet<>();
        int m=board.length;
        int n=board[0].length;
        boolean [][]visited=new boolean[m][n];
        //遍历整个二维数组
        for(int i=0;i<board.length; i++){
            for (int j = 0; j < board [0].length; j++){
                find(board,visited,i,j,m,n,result,root);
            }
        }
        System.out.print(result);
        return new LinkedList<String>(result);
    }

    private void find(char [] [] board, boolean [][]visited,int i,int j,int m,int n,Set<String> result,trieNode cur){
        //边界以及是否已经访问判断
        if(i<0||i>=m||j<0||j>=n||visited[i][j]) {
            return;
        }
        cur=cur.child[board[i][j]-'a'];
        visited[i][j]=true;
        if(cur==null) {
            //如果单词不匹配，回退到上一步
            visited[i][j]=false;
            return;
        }
        if(cur.isLeaf) {
            //找到单词，加入结果集
            result.add(cur.val);
        }
        find(board, visited,i+1, j, m, n, result, cur);
        find(board, visited, i, j+1, m, n, result, cur);
        find(board, visited, i, j-1, m, n, result, cur);
        find(board, visited,i-1, j, m, n, result, cur);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j]=false;
    }

}
