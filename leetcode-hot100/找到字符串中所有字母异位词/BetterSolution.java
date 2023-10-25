import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题解
 *
 * @author lql
 * @date 2023/10/24
 */

public class BetterSolution{
    private final static char A = 'a';

    public List<Integer> findAnagrams(String s, String p) {
        // 如果s的长度小于p的长度则无解
        if(s.length() < p.length()){
            return new ArrayList<>();
        }

        int length = p.length();
        // 此处将字符转为数字
        // 在计算中可以节省时间
        // 桶的思想
        int[] scount = new int[26];
        int[] pcount = new int[26];
        // 只需一次性将s和p转为char数组 => 相比于我的解法减少了大量的转换
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for(int i = 0;i < length;i++){
            ++scount[sc[i] - A];
            ++pcount[pc[i] - A];
        }

        List<Integer> result = new ArrayList<>();
        // 判断两个int数组，如果相同则说明下标0符合条件
        if(Arrays.equals(scount,pcount)){
            result.add(0);
        }

        // 依次计算sc中后一位字符
        for(int i = 0;i < sc.length - length;i++){
            --scount[sc[i] - A];
            ++scount[sc[i + length] - A];
            if(Arrays.equals(scount,pcount)){
                result.add(i + 1);
            }
        }

        return result;
    }
}
