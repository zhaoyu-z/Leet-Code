/*
19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]
 */
public class Q19 {
    // 快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode ptr_slow = res;
        ListNode ptr_fast = head;
        for (int i = 0; i < n; i++){
            ptr_fast = ptr_fast.next; // 快指针先走n步，这样快指针先到终点时，慢指针就是倒数第n个
        }

        while (ptr_fast != null){
            ptr_fast = ptr_fast.next;
            ptr_slow = ptr_slow.next;
        }

        ptr_slow.next = ptr_slow.next.next; // 删除节点
        return res.next;
    }
}
