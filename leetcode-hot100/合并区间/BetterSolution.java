import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lql
 * @date 2023/10/27
 */
public class BetterSolution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        // 根据start排序
        // 题解中使用Arrays.sort优化,自定义Comparator接口
        Arrays.sort(intervals, (first, last) -> first[0] - last[0]);

        // 判断end和后面start的大小
        // 题解中也对此进行了优化
        int start;
        int end;
        for(int i = 0;i < intervals.length;i++){
            start = intervals[i][0];
            end = intervals[i][1];
            // 判断result是否为空，为空则放入
            // 同时判断上一次放入结果中的end与现在的start的大小,如果小于则说明不覆盖,直接添加到result中
            if(result.size() == 0 || result.get(result.size() - 1)[1] < start){
                result.add(new int[]{start,end});
            } else {
                // 如果大于,说明前面的结果覆盖了当前的结果
                // 需要将上一次的end改为这次较大的end
                int lastEnd = result.get(result.size() - 1)[1];
                result.get(result.size() - 1)[1] = Math.max(lastEnd,end);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
