import java.util.*;
import java.util.stream.Collectors;

/*
15. 三数之和
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。


示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。

示例 2：
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。

示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 */
class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // 排序双指针，这样当和大于或小于目标值时，可以超某个方向固定移动指针
        Set<List<Integer>> ans = new HashSet<>(); // 用set，为了去重

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break; // 如果当前数已经大于0，由于是排过序的，那么三数之和必定大于0，直接返回
            if (i > 0 && nums[i] == nums[i-1]) continue; // 如果遇到重复的数，找到下一个不一样的数

            int j = i+1; // 左指针
            int k = n-1; // 右指针
            while (j < n && j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) { // 找到目标答案，加入ans，然后左右指针同时向内移动一格
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                    j++;
                    k--;
                }else if (nums[i] + nums[j] + nums[k] > 0) { // 数过大，右指针左移
                    k--;
                } else { // 数过小，左指针右移
                    j++;
                }
            }
        }
        return ans.stream().collect(Collectors.toList()); // set to list
    }
}
