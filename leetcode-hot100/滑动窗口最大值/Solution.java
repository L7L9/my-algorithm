import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * @author lql
 * @date 2023/10/25
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) return new int[0];
        if(k == 1) return nums;

        int[] result = new int[nums.length - k + 1];
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        // 初始化map
        for(int i = 0;i < k;i++){
            max = Math.max(max,nums[i]);
            map.put(nums[i],i);
        }
        result[0] = max;
        for(int i = 1;i < nums.length - k + 1;i++){
            // 用map来记录下标的位置
            // 当新窗口加入的值大于上一个窗口的最大值的时候
            // 则不需要使用map,直接将该值加入到result当中
            if(nums[i + k - 1] > max){
                max = nums[i + k - 1];
                result[i] = max;
            } else {
                int index = map.get(max);
                // 下标超出窗口的范围，需要重新计算最大值
                // 否则没有超出范围,max依然有效
                if(index == i - 1){
                    max = nums[i + k - 1];
                    for(int j = i;j < i + k - 1;j++){
                        max = Math.max(max,nums[j]);
                    }
                }
                result[i] = max;
            }
            map.put(nums[i + k - 1],i + k - 1);
        }

        return result;
    }
}
