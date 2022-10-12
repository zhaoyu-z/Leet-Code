import java.util.HashMap;
import java.util.Map;

/*
817. 链表组件
给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。

返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。



示例 1：
输入: head = [0,1,2,3], nums = [0,1,3]
输出: 2
解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。

示例 2：
输入: head = [0,1,2,3,4], nums = [0,3,1,4]
输出: 2
解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 */
public class Q817 {
    public int numComponents(ListNode head, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // 把nums中的数字存进map中，是为了利用map的方法“containsKey（）”来找到是否有值
        }

        ListNode cur = head; // iterator遍历
        int ans = 0;
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                ans++; // 记录组件个数
            }
            while (cur != null && map.containsKey(cur.val)) {
                cur = cur.next; // 组件可以变长，直到数值不在链表中
            }
            if (cur == null) break; // 如果到了链表结尾，退出循环
            cur = cur.next; // 检查下一个
        }

        return ans;
    }
}
