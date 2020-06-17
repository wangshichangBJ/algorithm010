package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShiChang Wang
 * @description 判断是否为异位字符串
 * @date 2020/6/17
 */
public class IsAnagram {

    public static void main(String[] args){
        String s= "alvxawa", t = "lavawxa";
        System.out.println(isAnagramMethod1(s, t));
    }

    /**
     * 分析
     * 1、字母异位词是指在两个字符串A和B中，A与B的字符相同但是顺序不同
     * 2、此处不要求区分大小写
     * 思路
     * 1、两个字符串字符相同，那么两个字符串的长度肯定相同
     * 2、长度相同的前提下，每个字符出现的次数是否相同，相等则为字母异位词，否则不是
     *
     * 复杂度分析
     *
     */
    public static Boolean isAnagramMethod1(String s, String t) {
        if (s.length() == t.length()){
            //长度相等
            Map<Character, Integer> sHashMap = new HashMap<>();
            Map<Character, Integer> tHashMap = new HashMap<>();
            char[] sChar = s.toCharArray();
            Integer num = 1;
            for (int i = 0; i < sChar.length; i++){
                Integer charNum = sHashMap.get(sChar[i]);
                if (charNum != null){
                    sHashMap.put(sChar[i],charNum+1);
                }else {
                    sHashMap.put(sChar[i],num);
                }
            }
            char[] tChar = t.toCharArray();
            for (int j = 0; j < tChar.length; j++){
                Integer charNum = tHashMap.get(tChar[j]);
                if (charNum != null){
                    tHashMap.put(tChar[j],charNum+1);
                }else {
                    tHashMap.put(tChar[j],num);
                }
            }
            Integer k = 0;
            for (int i = 0; i < sChar.length; i++){
                Integer sCharNum = sHashMap.get(sChar[i]);
                Integer tCharNum = tHashMap.get(sChar[i]);
                if (sCharNum.equals(tCharNum)){
                    k++;
                }
            }
            if (sChar.length == k){
                return true;
            }
        }
        return false;
    }

    /**
     * 分析
     * 1、长度相等
     * 2、两个字符串必须都有一样的字母，字母的出现的次数也要一样
     * 3、同一个编码集，排序就不会有问题
     *
     * 思路
     *  1、先判断长度是否相等
     *  2、由于只包含小写字母，将字母进行排序a->z
     *  3、比较两个字符数组相同下标位置的元素是否相同
     *
     * 复杂度分析
     *
     */
    public static Boolean isAnagramMethod2(String s, String t){
        if (s.length() == t.length()){
            char[] charsOfS = s.toCharArray();
            char[] charsOfT = t.toCharArray();
            Arrays.sort(charsOfS);
            Arrays.sort(charsOfT);
            if(Arrays.equals(charsOfS,charsOfT)){
                return true;
            }
        }
        return false;
    }

    public static Boolean isAnagramMethod3(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] counters = new int[26];
        for (int i = 0; i < s.length(); i++){
            //以小写字母a为基准数计数，a的ASCII码为97 ，现在字母a出现10次，counters[0]的值(字母a出现的次数)要累加10次
            counters[s.charAt(i) - 'a']++;
            //再遍历t，不断的进行累减操作，若是异位字符串，则counters[0]最终会被减成0
            counters[t.charAt(i) - 'a']--;
        }
        for (int counter : counters) {
            if (counter != 0){
                return false;
            }

        }
        return true;

    }

}
