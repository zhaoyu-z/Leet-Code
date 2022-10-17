/*
349. 两个数组的交集
给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
 */
import java.util.Arrays;

public class Q349 {
    /*
    排序加双指针
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0;// 答案的最后一个数字index
        int m = nums1.length;
        int n = nums2.length;
        int i = 0; // num1指针
        int j = 0; // num2指针
        int[] ans = new int[Math.min(m, n)]; // 交集长度一定小于等于两个数组中短的那个

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                if (a == 0 || ans[a-1] != nums1[i]) { // ans为空或与上一个不一样时才会添加
                    ans[a] = nums1[i];
                    a++; // 到下一个index去，准备添加新的值
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(ans, 0, a);
    }
}