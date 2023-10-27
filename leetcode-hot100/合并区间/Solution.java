import java.util.ArrayList;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author lql
 * @date 2023/10/27
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int start = 0;
        int end = 0;
        List<int[]> result = new ArrayList<>();
        // 根据start排序
        // 题解中使用Arrays.sort优化,自定义Comparator接口
        int temp = 0;
        for(int i = 0;i < intervals.length - 1;i++){
            for(int j = 0;j < intervals.length - 1 - i;j++){
                if(intervals[j][0] > intervals[j + 1][0]){
                    temp = intervals[j+1][0];
                    intervals[j+1][0] = intervals[j][0];
                    intervals[j][0] = temp;

                    temp = intervals[j+1][1];
                    intervals[j+1][1] = intervals[j][1];
                    intervals[j][1] = temp;
                }
            }
        }
        // 判断end和后面start的大小
        // 题解中也对此进行了优化
        for(int i = 0;i < intervals.length;i++){
            start = intervals[i][0];
            end = intervals[i][1];

            for(int j = i + 1;j < intervals.length;j++){
                if(end >= intervals[j][0]){
                    end = Math.max(end,intervals[j][1]);
                    ++i;
                } else {
                    break;
                }
            }

            int[] newNums = new int[]{start,end};
            result.add(newNums);
        }

        int[][] realResult = new int[result.size()][2];

        for(int i = 0;i < result.size();i++){
            realResult[i] = result.get(i);
        }
        return realResult;
    }
}
