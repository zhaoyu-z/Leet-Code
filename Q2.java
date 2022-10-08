/*
2. 两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(l1.val + l2.val); // 先把第一个数加起来当做head
        ListNode cur = res; // 一个iterator, 从head开始

        while (l1.next != null || l2.next != null){
            l1 = (l1.next == null) ? new ListNode() : l1.next; // 当没有更多node后，下一个node是空，不然是next
            l2 = (l2.next == null) ? new ListNode() : l2.next;

            cur.next = new ListNode(l1.val+l2.val+cur.val / 10); // 答案的下一个node是前数之和加进位数
            cur.val %= 10; // 下一个数值如果小于10，即使他本身，如果大于10，只保留十位数
            cur = cur.next;
        }

        if (cur.val >= 10){ // 当两个listnode都进行完遍历后，如果最后一个数大于10，则需要把进位数变为新的node，余数变为当前node
            cur.next = new ListNode(cur.val / 10);
            cur.val %= 10;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
