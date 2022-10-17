import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
18. 四数之和
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

示例 1：
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

示例 2：
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
 */
public class Q18 {
    /*
    排序+双指针
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        if (n < 4) return ans;

        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去重
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue; // 去重

                // 如果当前数跟后面的三个数的和已经比target大了，由于排序的关系，再往后找，他们的和也不可能比target小，所以可以break
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;

                int x = j+1; // 左指针
                int y = n-1; // 右指针
                while (x < y) {
                    long sum = (long) nums[i]+nums[j]+nums[x]+nums[y]; // long为了避免整型溢出
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[x]);
                        tmp.add(nums[y]);
                        if (!ans.contains(tmp)) ans.add(tmp); // 避免重复答案
                        while (x < y && nums[x] == nums[x+1]) x++;
                        x++;
                        while (x < y && nums[y] == nums[y-1]) y--;
                        y--;
                    } else if (sum < target) {
                        x++;
                    } else {
                        y--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
    }
}
