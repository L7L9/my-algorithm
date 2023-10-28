/**
 * 题解
 *
 * @author lql
 * @date 2023/10/28
 */
public class BetterSolution {
    public int firstMissingPositive(int[] nums) {
        // 思路：
        // 将原数组当作一个hash表
        // 易知:假设nums为从1递增的数组,则答案为nums.length + 1;所以,结果一定为[1,nums.length + 1]的其中一个数字
        // 1.将下标作为标识,用于存[下标+1]的数值
        // 2.再次遍历,当nums[i] != i + 1时,说明当前下标为答案
        // 说明:时间=>O(n + n) = O(n),空间=>由于使用了原数组,且交换数值时只需要维护一个temp,因此未违反题目要求
        int length = nums.length;
        int temp = 0;
        for(int i = 0;i < length;i++){
            // 前面两个条件用于判断是否在[1,length]之间
            // 第三个条件: 用于判断 当前下标对应的数值 是否在对应的下标当中,如果不是则要置换
            // 若当前下标置换后, 当前下标对应的数值 不在对应的下标当中,仍旧需要置换,因此需要用while判断而不是if判断
            while(nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]){
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i = 0;i < length;i++){
            if(nums[i] != i + 1){
                return i;
            }
        }
        return length + 1;
    }
}
