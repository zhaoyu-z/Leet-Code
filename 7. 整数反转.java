/*
7. 整数反转
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：
输入：x = 123
输出：321

示例 2：
输入：x = -123
输出：-321

示例 3：
输入：x = 120
输出：21

示例 4：
输入：x = 0
输出：0
 */
class Q7 {
    public int reverse(int x) {
        int flag = -1; // 是否是负数
        StringBuilder sb;
        /*
        数字转化为string，reverse之后再加上负号（如果有）
         */
        if (x < 0) {
            sb = new StringBuilder(String.valueOf(-x));
            flag = 1;
        } else {
            sb = new StringBuilder(String.valueOf(x));
        }
        sb.reverse();
        try {
            // Integer.parseInt只能处理[−2^31,  2^31 − 1]范围内的数字
            // 所以如果出了exception，证明数字不在这个区间内，返回0
            return -flag * Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
