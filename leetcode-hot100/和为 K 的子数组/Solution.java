/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * @author lql
 * @date 2023/10/25
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 纯暴力...(枚举)
        int head = 0;
        int sum = 0;
        int count = 0;
        while(head < nums.length){
            sum = 0;
            for(int i = head;i < nums.length;i++){
                sum += nums[i];
                if(sum == k){
                    count++;
                }
            }
            head++;
        }
        return count;
    }
}
