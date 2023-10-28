import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 注意:请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * @author lql
 * @date 2023/10/28
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        // 排序 + 查找(再改进可以用二分查找)
        // 二分查找不符合时间要求
        // int length = nums.length;
        // Arrays.sort(nums);
        // if(nums[length - 1] <= 0){
        //     return 1;
        // }

        // int head = 0;
        // while(head < length){
        //     if(nums[head] <= 0){
        //         head++;
        //     } else {
        //         break;
        //     }
        // }
        // if(nums[head] > 1){
        //     return 1;
        // }
        // for(int i = head + 1;i < length;i++){
        //     if(nums[i] > nums[i - 1] + 1){
        //         return nums[i - 1] + 1;
        //     }
        // }
        // return nums[length - 1] + 1;

        int length = nums.length;
        // set最大值为数组长度,不符合题目要求
        Set<Integer> set = new HashSet<>();

        for(int i = 0;i < length;i++){
            if(nums[i] > 0){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                }
            }
        }
        for(int i = 1;i < set.size() + 1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return set.size() + 1;
    }
}