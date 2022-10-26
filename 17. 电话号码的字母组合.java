import java.util.*;

/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例 2：
输入：digits = ""
输出：[]

示例 3：
输入：digits = "2"
输出：["a","b","c"]
 */
class Q17 {
    /*
    方法一：递归
     */
    public List<String> letterCombinations1(String digits) {
        List<String> ans = new ArrayList<>();

        Map<Character, String> map = new HashMap<>(); // 对应
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(map, digits, 0, ans, new StringBuilder());
        return ans;
    }
    // 递归dfs
    public void backtrack(Map<Character, String> map, String digits, int index, List<String> ans, StringBuilder current) {
        if (index == digits.length()) { // 当前已遍历到最后一个字符，把目前的组合加入ans
            ans.add(current.toString());
        } else {
            Character digit = digits.charAt(index);
            String letters = map.get(digit);
            for (Character letter : letters.toCharArray()) { // 对于后面每一个数字的所有字符，都添加一遍
                current.append(letter);
                backtrack(map, digits, index+1, ans, current);
                current.deleteCharAt(index); // 删掉此字符，避免重复利用
            }
        }
    }

    /*
    方法二：队列
     */
    public List<String> letterCombinations2(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.length() == 0) return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            if (queue.size() == 0) { // 一开始把第一个数字的字母加到队列里
                Character num = digits.charAt(i);
                String chars = map.get(num);
                for (int j = 0; j < chars.length(); j++) {
                    queue.add(String.valueOf(chars.charAt(j)));
                }
                continue;
            }
            int size = queue.size(); // （这里不能节省size变量， 因为q的size会变， 我们这里只拿初始size）
            /*
            对于每一个后续数字的字母们，从队列里拿出一个字母与之相加，然后重新加入队列中，一直到把队列里初始字母们遍历完
            建议观看这个题解： https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solution/hui-su-dui-lie-tu-jie-by-ml-zimingmeng/#%E6%96%B9%E6%B3%95%E4%BA%8C%EF%BC%9A%E9%98%9F%E5%88%97
             */
            for (int n = 0; n < size; n++) {
                String s = queue.poll();
                Character num = digits.charAt(i);
                String chars = map.get(num);
                for (int j = 0; j < chars.length(); j++) {
                    queue.add(s+chars.charAt(j));
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
