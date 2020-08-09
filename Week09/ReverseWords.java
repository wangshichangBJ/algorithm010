/**
 * @author ShiChang Wang
 * @description 反转字符串中的单词
 * @date 2020/8/6
 */
public class ReverseWords {
    public String reverseWords(String s) {

        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                // 搜索首个空格
                i--;
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            while(i >= 0 && s.charAt(i) == ' ') {
                // 跳过单词间空格
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        return res.toString().trim();

    }
}
