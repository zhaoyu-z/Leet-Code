import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, ans, 0, 0, new StringBuilder());
        return ans;
    }

    public void dfs(int n, List<String> ans, int left, int right, StringBuilder sb) {
        if (sb.length() == n*2) {
            ans.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(n, ans, left+1, right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) {
            sb.append(')');
            dfs(n, ans, left, right+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
// @lc code=end

