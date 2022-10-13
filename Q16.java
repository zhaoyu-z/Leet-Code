import java.util.Arrays;

/*
16. 最接近的三数之和
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。



示例 1：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

示例 2：
输入：nums = [0,0,0], target = 1
输出：0
 */
public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2]; // 三数之和
        int diff = Math.abs(target - ans); // 最接近的就是绝对差最小
        if (n == 3) return ans;

        for (int i = 0; i < n; i++) {
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int originalDiff = diff;
                int sum = nums[i]+nums[j]+nums[k];
                diff = Math.min(Math.abs(target - ans), Math.abs(target - sum));
                if (diff != originalDiff) {
                    ans = sum; // 如果差有变化，说明拿到了更小的差值，那么更新当前三数之和
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum; // 三数之和等于target的时候，已经 最接近了，可以直接返回
                }
            }
        }
        return ans;
    }
}
