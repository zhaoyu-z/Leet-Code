/*
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"
 */
public class Q5 {
    /*
    枚举所有的回文中心并尝试扩展，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。
    对所有的长度求出最大值，即可得到最终的答案。
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 从他本身开始扩展，回文串长度为奇数
            int len2 = expandAroundCenter(s, i, i + 1); // 从他和他下一个字符开始扩展，回文串长度为偶数
            int len = Math.max(len1, len2);
            if (len > end - start) { // 对于每一个字符串的最长回文串，跟当前已找到的长度对比，并更新值
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1); // 输出子字符串
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
