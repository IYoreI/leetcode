package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/4/27 9:24
 * @description
 */
public class BM1 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dubby = new ListNode(-1);
        dubby.next = head;
        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            p.next = q.next;
            q.next = dubby.next;
            dubby.next = q;
            q = p.next;
        }
        return dubby.next;
    }
}
