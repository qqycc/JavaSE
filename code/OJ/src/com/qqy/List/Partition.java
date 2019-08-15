package com.qqy.list;

/**
 * 编写代码，以给定值×为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针ListNode*pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 * 思路：
 *      设置小数链表和大数链表，分别追加小于x的值和大于等于x的值。
 *      将两个链表连接起来，返回。
 * Author:qqy
 */
public class Partition {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode smallList=new ListNode(-1);
        ListNode smallHead=smallList;
        ListNode bigList=new ListNode(-1);
        ListNode bigHead=bigList;
        ListNode cur=pHead;
        while (cur!=null) {
            if (cur.val < x) {
                smallHead.next = new ListNode(cur.val);
                smallHead = smallHead.next;
            } else {
                bigHead.next = new ListNode(cur.val);
                bigHead = bigHead.next;
            }
            cur = cur.next;
        }
        smallHead.next=bigList.next;
        return smallList.next;
    }

}
