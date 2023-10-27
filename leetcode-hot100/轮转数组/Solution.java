/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author lql
 * @date 2023/10/27
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        // 利用除于计算要轮转的区间
        k = k % length;
        int[] t = new int[k];
        // 将要被覆盖的区间保存起来
        for(int i = 0;i < k;i++){
            t[i] = nums[length - k + i];
        }
        // 后移k位
        for(int i = length - 1;i >= k;i--){
            nums[i] = nums[i - k];
        }
        // 将保存的值复制到原数组中
//        for(int i = 0;i < k;i++){
//            nums[i] = t[i];
//        }
        System.arraycopy(t, 0, nums, 0, k);
    }
}
