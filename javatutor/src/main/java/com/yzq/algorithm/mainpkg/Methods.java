package com.yzq.algorithm.mainpkg;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/29 10:18
 * @Modified By:
 */
public class Methods {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
