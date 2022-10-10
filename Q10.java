/*
10. 正则表达式匹配
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。


示例 1：
输入：s = "aa", p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

示例 2:
输入：s = "aa", p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

示例 3：
输入：s = "ab", p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
class Q10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1]; // f[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') { // 如果遇到*，看它前一个字符就行
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) { // 如果当前字符是'.'，那么看字符串前一个字符即可
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else if (matches(s, p, i, j)) { // 如果 p 的第 j 个字符是一个小写字母，那么我们必须在 s 中匹配一个相同的小写字母
                    f[i][j] = f[i - 1][j - 1];
                }
            }
            if (!check(f, i)) { // 如果从某个字符开始已经不能匹配了，那么后面的也都不能匹配，直接返回false
                return false;
            }
        }
        // show(f);
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public void show(boolean[][] dp) {

        for (boolean[] booleans : dp) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < dp[0].length; j++) {
                if (booleans[j]) {
                    s.append("true ");
                } else {
                    s.append("false ");
                }
            }
            System.out.println(s);
        }
    }

    public boolean check(boolean[][] dp, int i) {
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[i][j]) return true;
        }
        return false;
    }
}
