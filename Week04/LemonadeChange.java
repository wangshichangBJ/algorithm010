/**
 * @author ShiChang Wang
 * @description 柠檬水
 * @date 2020/7/2
 */
public class LemonadeChange {

    public static void main(String[] args) {
        // TO TEST
    }


    /**
     * 问题分析
     * 1、最初的钱数是0，第一位顾客必须是给的5元，否则返回false;
     * 2、下一位顾客（当前购买柠檬水的顾客）的钱如果是5，直接收款，然后next；否则当前顾客给的钱数Mn-5的值Val，在之前顾客给的钱中，挑选出几个求和等于val;
     * 3、如果存在求和等于val的几个数，则判断下一个客户，否则返回fasle
     * 解题思路
     * 1、先判断第一个值是否为5；
     * 2、使用循环分析中的第2步
     * 复杂度分析
     */
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            if (bills[0] != 5){
                return false;
            }
            int five = 0, ten = 0;
            for (int bill : bills) {
                switch (bill){
                    case 5 : {
                        five++;
                    }
                    break;
                    case 10 : {
                        five--;
                        ten++;
                    }
                    break;
                    case 20 : {
                        //先判断有没有10元的钱，允许5元的钱被减成负数
                        if (ten > 0 ){
                            ten-- ;
                            five--;
                        }else {
                            //判断5元的钱有没有三张以上
                            five -= 3;
                        }
                        break;
                    }
                    default: break;
                }
                if (five < 0){
                    //5元的被减成负数
                    return false;
                }
            }
            return true;
        }

    }
}
