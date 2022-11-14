import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tips {
    /**
     * 思路：滑动窗口算法：左右指针：left right
     * left: 起始位置  right：没有重复的就往后走直到出现重复的。记录一下left与right之间的大小
     * 然后left往后移动一个，right继续以上操作没有重复的就往后走直到出现重复的。
     * 判断有没有重复的我们使用 HashSet，left往后移动一个，我们就从HashSet中移除相应的元素
     * right往后走一个没有重复的我们就往HashSet中存一个
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int n = s.length();
        int count = 0; //计数用
        int left = 0;
        for(int right = 0; right < n; right++) {
            if(!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                count = Math.max(count, right-left+1);
            }else {
                hashSet.remove(s.charAt(left));
                left++;
                while (hashSet.contains(s.charAt(right))) {
                    hashSet.remove(s.charAt(left));
                    left++;
                }
                hashSet.add(s.charAt(right));
            }
        }
        return count;
    }
}
