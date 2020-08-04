/**
 * @author ShiChang Wang
 * @description 移动零（leetcode:283）
 * @date 2020/8/3
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,0,7,5,0,34,0,6};
        int[] ints = moveZeroes(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; j < nums.length; j++) {
            //当元素为0时，i指针不进行加1，j指针进行加1，获取数组的下一个元素
            //当数据的下一个元素不为0时，此时由于j进行了加1操作，所以i小于j，两者不相等
            if (nums[j] != 0) {
                //当前元素的值不为0
                if (i != j){
                    //避免自己和自己交换，增加无用操作
                    //此时由于j进行了加1操作，所以i小于j，两者不相等。就将j位置的元素和i位置的元素值0进行位置交换
                    //这样不为0的值就向左移动，0值就像右移动。通过循环将0移动到最后一位
                    nums[i] = nums[j];
                    //此处没有使用temp来保存nums[i]的值，是因为nums[i]肯定等于0，所以直接赋值给0即可
                    nums[j] = 0;
                }
                //当值不为0时，保持i指针与j指针同步
                i++;
            }
        }
        return nums;
    }
}
