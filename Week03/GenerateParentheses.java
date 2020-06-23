/**
 * @author ShiChang Wang
 * @description 括号生成函数
 * @date 2020/6/23
 */
public class GenerateParentheses {
    // TO TEST
    public static void main(String[] args) {
        generateParentheses(3);

    }

    /**
     * 分析
     * 1、字符为左小括号和右小括号，只有这两种
     * 2、左括号的数量根据输入的值判断数量
     * 3、右括号不能超过已输入的左括号数量
     *
     * 思路
     * 1、先不考虑括号的匹配规则，输入n个左括号，然后输入n个右括号，输出所有的匹配结果
     * 2、处理不合法的括号组合，将参数设置为左括号数量、右括号数量和括号的合法成对数量
     * 3、跳出递归条件为，左括号和右括号的数量都等于了n(允许出现的合法对数)
     * 4、只有当左括号的数量小于n时，才能添加左括号，执行左括号追加的递归操作
     * 5、只有当右括号的数量小于当前左括号的数量，即保证括号合法性的基础上，执行右括号的追加操作
     *
     * 复杂度分析
     * 由于使用递归操作，所以时间复杂度是O(logn)
     * 由于并没有占用多余的内存空间，所以为O(1)
     */
    public static void generateParentheses(int n){
        //不考虑括号合法性
//        _generate(0,2 * n,"");
        _generate(0,0, n,"");

    }


    //    private static void _generate(int level, int max, String s) {
    private static void _generate(int left, int right, int n, String s) {
        //跳出递归的条件,左括号数量和右括号数量都达到n个
//        if (level > max){
        if (left == n && right == n){
            System.out.println(s);
            return;
        }

        //调用递归
//        _generate(level+1,max,s+"(");
//        _generate(level+1,max,s+")");
        if (left < n) {
            //允许添加左括号,右括号不作处理
            _generate(left + 1, right,n, s + "(");
        }
        if (left > right) {
            //追加右括号，左括号的数量不变
            _generate(left,right + 1, n, s + ")");
        }
    }

}
