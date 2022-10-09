/*
6. Z 字形变换
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);


示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"

示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I

示例 3：
输入：s = "A", numRows = 1
输出："A"

 */

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    public String convert(String s, int numRows) {
        if(numRows < 2 || numRows > s.length()) return s;

        /*
        每一行建立一个新的StringBuilder，用来连接字符
         */
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        int i = 0, flag = -1; // i代表当前行数，flag代表行数的变化
        for(char c : s.toCharArray()) {
            rows.get(i).append(c); // 把字符存进当前行数的StringBuilder中
            if(i == 0 || i == numRows -1) flag = - flag; // 当行数到了末尾或开头，折返方向
            i += flag; // 更新行数
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) // 最后把所有字符串连起来
            res.append(row);
        return res.toString();
    }
}
