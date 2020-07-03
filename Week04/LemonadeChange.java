import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ShiChang Wang
 * @description 柠檬水
 * @date 2020/7/2
 */
public class LemonadeChange {

    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        // TO TEST
        int[] bills = {5, 10, 10, 10, 10, 20};
        solution.lemonadeChange(bills);
    }


    /**
     * 问题分析
     * 1、最初的钱数是0，第一位顾客必须是给的5元，否则返回false;
     * 2、下一位顾客（当前购买柠檬水的顾客）的钱如果是5，直接收款，然后next；否则当前顾客给的钱数Mn-5的值Val，在之前顾客给的钱中，挑选出几个求和等于val;
     * 3、如果存在求和等于val的几个数，则判断下一个客户，否则返回fasle
     * 解题思路
     * 思路一：暴力求解，可以解决所有金额的情况
     * 1、先判断第一个值是否为5；
     * 2、使用循环分析中的第2步
     *
     * 思路二：只针对5元  10元  20元
     * 利用贪心算法解决
     * 复杂度分析
     *
     */
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            return method1(bills);
//            return method2(bills);
        }

    }

    /**
     * 暴力算法，针对所有金额的情况
     * @param bills
     * @return
     */
    private Boolean method1(int[] bills){
        //新建一个双端队列，用来动态存储上架手中的不同金额的纸币
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        if (bills[0] != 5){
            return false;
        }
        for(int bill : bills){
            //获取当前顾客的找零值
            int charge = bill - 5;
            if (charge == 0){
                //将当前顾客给的5元添加到队列中，用于后面顾客的找零
                queue.add(bill);
                continue;
            }
            while (charge > 0){
                //商家手中有纸币时，定义一个标识位，用来判断是否可以满足当前顾客正好找零
                Boolean flag = false;
                //遍历queue,找合适找零的纸币
                for (Integer holdMoney : queue) {
                    if (charge - holdMoney >= 0){
                        charge = charge - holdMoney;
                        queue.remove(holdMoney);
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    //上面for循环可以减1个，就不进入该逻辑，直接跳到下一个while循环，由于charge没有被减到0，所以在从queue中取出下一个值，与charge相减，直到charge被减到0
                    return false;
                }
            }
            if (bill < 20){
                //由于20元不能用于找0，所有不保存20额度的纸币
                queue.add(bill);
            }

        }
        return true;
    }

    /**
     * 贪心算法
     * @param bills
     * @return
     */
    private Boolean method2(int[] bills){
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
