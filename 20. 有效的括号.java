import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false
 */
class Q20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(); // 括号对应
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        if(s.length() > 0 && map.containsKey(s.charAt(0))) return false;
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == map.get(c)) { // 把同类括号消掉
                stack.pop();
                continue;
            }
            stack.push(c); // 如果不能消掉就加入到stack里面
        }
        return stack.empty(); // stack为空代表都消掉了，那么有效，反之无效
    }
}
