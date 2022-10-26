/*
4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。


示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2

示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
class Q4 {
    /*
    用两个数来遍历两个array，直到第中位数个,这样是为了合并奇数中位数和偶数中位数的情况
    如果是奇数中位数，那两个数相同，如果是偶数中位数，那取两个数的平均数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftMiddle = (nums1.length + nums2.length + 1) / 2;
        int rightMiddle = (nums1.length + nums2.length + 2) / 2;
        double left = getKth(nums1, nums2, 0, 0, leftMiddle);
        double right = getKth(nums1, nums2, 0, 0, rightMiddle);
        return (left + right) / 2;
    }

    /*
    @param nums1: 数组1
    @param nums2: 数组2
    @param left1: 数组1的开始下标
    @param left2: 数组2的开始下标
    @param k: 中位数，在本题中可以看做是第k小数的特殊情况，所以理解为剩下需要找到的第k小的数


    找到两个数组的中位数
    1.利用二分查找，每次找两个数组中第k/2个数，a（nums1）和b（nums2）

    如果a==b，那么去掉任意一个nums的前k/2个数，
    如果a<b，那么去掉nums1的前k/2个数，（在迭代中表现为从a+1个数开始找）
    如果a>b，那么去掉nums1的前k/2个数，（在迭代中表现为从b+1个数开始找）

    2.去掉之后，更新k，再继续找剩下两个数组中前k/2个数，
    如果有一个数组的长度不够取第k/2个数，
    那么直接k直接减掉这个数组剩下的长度，
    取另一个数组第k个数

    如果只剩下最后一个数需要找，
    那么直接返回两个指针的最小值
     */
    private double getKth(int[] nums1, int[] nums2, int left1, int left2, int k) {

        // 有两种base case
        // 1. 当指针定位超过了数组长度，则直接返回另一个数组的中位数
        // 2. 当k == 1时，就直接返回两个指针处的最小值
        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            int num1 = nums1[left1 + k - 1];
            int num2 = nums2[left2 + k - 1];
            return Math.min(num1, num2);
        }

        // 每组需要提供的元素个数，用于定位
        int elementNum = k / 2;
        int loc1 = left1 + elementNum - 1;
        int loc2 = left2 + elementNum - 1;

        // 如果后续的元素个数不够，则定位到该数组的最后一个元素
        if (loc1 >= nums1.length) {
            loc1 = nums1.length - 1;
        }
        if (loc2 >= nums2.length) {
            loc2 = nums2.length - 1;
        }

        if (nums1[loc1] < nums2[loc2]) {
            return getKth(nums1, nums2, loc1 + 1, left2, k - (loc1 - left1 + 1));
        }

        return getKth(nums1, nums2, left1, loc2 + 1, k - (loc2 - left2 + 1));
    }
}
