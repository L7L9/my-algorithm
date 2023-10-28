/**
 * 1.给你一个整数数组 nums，返回数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积
 * 2.题目数据保证数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * 3.不要使用除法，且在 O(n)时间复杂度内完成此题
 *
 * @author lql
 * @date 2023/10/28
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        // 计算左边的乘积
        left[0] = 1;
        for(int i = 1;i < length;i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[length - 1] = 1;
        for(int i = length - 2;i >= 0;i--){
            right[i] = right[i + 1] * nums[i + 1];
        }

        // 将要计算的下标作为一个分界线分为两边
        // 分别计算分界线 左边的乘积和右边的乘积
        // 因此,当前下标除自身之外的乘积值就是左边的乘积 * 右边的乘积
        for(int i = 0;i < length;i++){
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}