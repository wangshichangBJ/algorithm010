/**
 * @author ShiChang Wang
 * @description 字典树
 * @date 2020/7/23
 */
public class Trie {

    //属性
    private Boolean isEnd;

    private Trie[] next;

    //无参构造函数
    Trie(){
        this.isEnd = false;
        //初始换存放26个英文字母
        this.next = new Trie[26];
    }

    //有参构造函数
    Trie(Boolean _isEnd, Trie[] _next){
        this.isEnd = _isEnd;
        this.next = _next;
    }

    /**
     * 字典树插入一个单词
     * @param word 单词
     */
    public void insert(String word) {
        //单词为空，就不进行 插入操作
        if (word == null || word.length() == 0) {
            return;
        }
        //new一个trie对象
        Trie curr = this;
        //将字符串转换成字符数组
        char[] chars = word.toCharArray();
        //遍历每个字符，将字符添加到字典树中
        for (int i = 0; i < chars.length; i++) {
            //定义树的索引
            int n = chars[i] - 'a';
            if (curr.next[n] == null) {
                curr.next[n] = new Trie();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    /**
     * 查询单词是否在字典树
     * @param word
     * @return
     */
    public Trie search(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++ ) {
            //获取第i个字符的节点
            node = node.next[chars[i] - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    /**
     * 判断单词是否在字典树中
     * @param word
     * @return
     */
    public Boolean searchWord(String word) {
        Trie search = search(word);
        return search != null && search.isEnd;
    }

    /**
     *
     * @param prefix
     * @return
     */
    public Boolean startWith(String prefix) {
        Trie search = this.search(prefix);
        return search != null;
    }



}
