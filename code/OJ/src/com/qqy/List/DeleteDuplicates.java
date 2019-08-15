package com.qqy.list;


/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 思路：
 *      因为是有序的，因此重复的元素一定是挨着的，只需要遍历比较。
 * Author:qqy
 */
public class DeleteDuplicates {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        if(cur==null){
            return null;
        }
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
