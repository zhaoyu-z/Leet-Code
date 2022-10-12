/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 */
public class Q14 {
    /*
    把每一个string都进行比较，得到最长的前缀，每次更新前缀即可
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int len = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++){
            len = Math.min(len, get(prefix, strs[i]));
            prefix = prefix.substring(0, len);
        }
        return prefix;
    }

    private int get(String s1, String s2){
        int n = Math.min(s1.length(), s2.length());
        int count = 0;
        for (int i = 0; i < n; i++){
            if (s1.charAt(i) == s2.charAt(i)){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
