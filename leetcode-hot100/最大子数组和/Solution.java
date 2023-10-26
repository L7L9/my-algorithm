/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * @author lql
 * @date 2023/10/26
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        // 动态规划
        int[] temp = new int[nums.length];
        temp[0] = nums[0];

        for(int i = 1;i < nums.length;i++){
            // 题解中用 [比较i-1的值大于0] 作为判断依据
            temp[i] = Math.max(nums[i] + temp[i-1],nums[i]);
        }
        // 原本用Integer.MIN_VALUE,相较于tmep[0]占用内存大
        int max = temp[0];
        // 找出最大值
        for(int i =0;i < nums.length;i++){
            max = Math.max(max,temp[i]);
        }

        // 优化空间的写法:只需要记录pre值,并且在记录过程中计算max值
        return max;
    }
}
