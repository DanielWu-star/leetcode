package com.study.wqz.leetcode.normal.node;


/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/14 21:30
 * @description：给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @modified By：
 * @version: $
 * @since ：
 */
public class ListNodeSum {

    public static ListNode findAddNode(ListNode l1,ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args){
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(4,node1);
        ListNode node3=new ListNode(2,node2);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(6,node4);
        ListNode node6=new ListNode(5,node5);
        findAddNode(node3,node6);
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
