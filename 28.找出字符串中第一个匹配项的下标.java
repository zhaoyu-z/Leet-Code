/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); // 还有KMP和滑动窗口的做法。
        // 不过我觉得这题没啥意义，中等题不应该用KMP做，滑动窗口也不是最优解（因为滑动窗口是O((m-n)*n))
    }
}
// @lc code=end

