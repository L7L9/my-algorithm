import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * tips: s和p只包含小写字母
 * @author lql
 * @date 2023/10/24
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 将字符串转化char数组再排序
        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        String str = new String(pc);

        List<Integer> result = new ArrayList<>();
        int length = pc.length;
        for(int i = 0;i < s.length() - length + 1;i++){
            // 同样，截取s中与p的长度相同的一段字符串
            // 然后转为char数组再排序
            // 最后与str比较内容是否相同
            // 相同则将下标加入result中
            char[] sc = s.substring(i,i + length).toCharArray();
            Arrays.sort(sc);
            String s1 = new String(sc);
            if(s1.equals(str)){
                result.add(i);
            }
        }
        // 弊端：
        // 1. 大量操作字符串，耗费的时间多
        // 2. 字符串与char[]数组之间相互转化，浪费了大量时间空间

        return result;
    }
}
