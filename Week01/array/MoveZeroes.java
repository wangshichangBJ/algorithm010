package array;

/**
 * @author ShiChang Wang
 * @description 移动0
 * @date 2020/6/27
 */
public class MoveZeroes {
    // TO TEST
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,1,0,3,5,0,100,2,0};
        int[] ints = moveZeroes1(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println("----------------------------");

        int[] ints1 = moveZeroes2(arr);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    /**
     * 分析
     * 将元素值为0的全部移动到数组的后面
     * 不为0的值移动到数组前面
     *
     * 思路
     *
     * 复杂度分析
     *
     */
    public static int[] moveZeroes1(int[] nums){
        int j = 0;
        for (int i = 0;i < nums.length; i++){
            if (nums[i] != 0){
                //遍历的当前元素不为0时，将该元素放置到j位置
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    /**
     * 交换非0元素和0元素的位置
     * 设置下表j从0开始，把非0的元素进行保存，从新添加到数组中
     * @param nums
     */
    public static int[] moveZeroes2(int[] nums){
        int j = 0;
        for (int i =0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

}
