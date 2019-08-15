package com.qqy.list;

/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode*A，ListNode*B，请返回A+B的结果（ListNode*）。
 * Author:qqy
 */
public class Plus {
    //进位
    static int carry=0;
    public static ListNode plusAB(ListNode a, ListNode b) {
        ListNode plus = new ListNode(-1);
        ListNode cur=plus;

        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        while (a != null&&b!=null) {
            int sum=a.val + b.val+carry;
            cur.next = new ListNode(sum%10);
            if(sum>9){
                carry=sum/10;
                if(a.next==null||b.next==null){
                    cur.next.next=new ListNode(sum/10);
                }
            }else {
                carry = 0;
            }
            a = a.next;
            b = b.next;
            if(a != null || b != null) {
                cur = cur.next;
            }
            if(a!=null&&b==null){
//                while(a!=null) {
//                    int sum1=a.val+carry;
//                    cur.next = new ListNode(sum1%10);
//                    if(sum1>9){
//                        carry=sum1/10;
//                        if(a.next==null){
//                            cur.next.next=new ListNode(sum1/10);
//                        }
//                    }else {
//                        carry = 0;
//                    }
//                    cur=cur.next;
//                    a=a.next;
//                }
                check(a,cur);
            }
            //a短
            if(a==null&&b!=null){
//                while(b!=null) {
//                    int sum1=b.val+carry;
//                    cur.next = new ListNode(sum1%10);
//                    if(sum1>9){
//                        carry=sum1/10;
//                        if(b.next==null){
//                            cur.next.next=new ListNode(sum1/10);
//                        }
//                    }else {
//                        carry = 0;
//                    }
//                    cur=cur.next;
//                    b=b.next;
//                }
                check(b,cur);
            }
        }
        return plus.next;
    }

    public static void check(ListNode b,ListNode cur){
            while(b!=null) {
                int sum1=b.val+carry;
                cur.next = new ListNode(sum1%10);
                if(sum1>9){
                    carry=sum1/10;
                    if(b.next==null){
                        cur.next.next=new ListNode(sum1/10);
                    }
                }else {
                    carry = 0;
                }
                cur=cur.next;
                b=b.next;
            }
    }

//    public static void checkCarry(ListNode a,ListNode b,int sum,ListNode cur){
//        cur.next = new ListNode(sum%10);
//        if(sum>9){
//            carry=sum/10;
//            if(a.next==null||b.next==null){
//                cur.next.next=new ListNode(sum/10);
//            }
//        }else {
//            carry = 0;
//        }
//    }

    public static void main(String[] args) {
//        ListNode a=new ListNode(3);
//        a.next=new ListNode(5);
//        a.next.next=new ListNode(7);
//        a.next.next.next=new ListNode(2);
//        a.next.next.next.next=new ListNode(5);
//        ListNode b=new ListNode(2);
//        b.next=new ListNode(9);
//        b.next.next=new ListNode(4);
//        b.next.next.next=new ListNode(4);
//        b.next.next.next.next=new ListNode(3);
        ListNode a=new ListNode(9);
//        a.next=new ListNode(8);
        ListNode b=new ListNode(9);
//        b.next=new ListNode(9);

        ListNode res=plusAB(a,b);
        while (res!=null) {
            System.out.println(res.val);
            res=res.next;
        }
    }
   static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
