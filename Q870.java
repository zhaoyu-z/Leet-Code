import java.util.*;

/*
870. 优势洗牌
给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。

返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。



示例 1：

输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
输出：[2,11,7,15]
示例 2：

输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
输出：[24,32,8,12]
 */
public class Q870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n]; // nums2索引
        for (int i = 0; i < n; i++) idx[i] = i; // idx:[0, 1, 2, 3]
        Arrays.sort(nums1);
        Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]); //根据nums2数据升序，排序nums2(索引)
        int L = 0, R = n - 1; // nums2(索引)的左右指针
        for (int num : nums1) { // 遍历nums1
            if (num > nums2[idx[L]]) nums2[idx[L++]] = num; // 可以满足 nums1[i] > nums2[i]
            else nums2[idx[R--]] = num; //丢到数组最后
        }
        return nums2;
    }
}
