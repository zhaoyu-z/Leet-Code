
/*
300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
 */
public class Q300 {
    /*
    动态规划

    dp[] 表示从每个num开始最长的递增子序列
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] increasing = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            increasing[i] = 1; // 初始化为1
        }

        for (int i = n-1; i >= 0; i--) { // 从后往前，可以减少迭代次数
            for (int j = i+1; j < n; j++) { // 查后面的每一个数的最长子序列长度
                if (nums[i] < nums[j]) { // 是递增子序列
                    increasing[i] = Math.max(increasing[i], increasing[j]+1); // 加一之后与当前数比较
                    ans = Math.max(increasing[i], ans); // 更新最大值
                }
            }
        }
         return ans;
    }
}
