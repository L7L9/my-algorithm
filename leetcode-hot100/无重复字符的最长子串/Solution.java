import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串s，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author lql
 * @date 2023/10/24
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        char[] str = s.toCharArray();
        int max = 0;
        int index = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < str.length;i++){
            if(map.containsKey(str[i])){
                // index需要指向上一个重复的字符下标 + 1 与自身比较的较大值
                // 为什么要比较 => 因为有重复的字符可能很长时间没遇到
                // 在后面突然遇到时index已经超出字符下标
                index =  Math.max(index,map.get(str[i]) + 1);
            }
            // 每次遇到都要更新下标
            map.put(str[i],i);

            max = Math.max(max,i - index + 1);
        }
        return max;
    }
}
