import java.util.HashMap;
import java.util.Map;

/*
3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
class Q3 {
    public int lengthOfLongestSubstring(String s) {
        /*
        这题用滑动窗口做
         */
        int ans = 0;
        int start = 0; //字符串开始的index
        Map<Character, Integer> map = new HashMap<>(); // pair：字符，字符下标
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { // 如果遇到一个重复字符，这个字符肯定是当前字符串的首字符，那么把首字符移除即可
                start = Math.max(start, map.get(s.charAt(i))+1); // 通过把开始index右移一位来移除首字符
            }
            map.put(s.charAt(i), i); // 把字符和字符下标加入map
            ans = Math.max(ans, i - start + 1); // 当前index减去开始index+1即为字符串长度
        }
        return ans;
    }
}
