package org.jp.leetcode.mergetwisortedlist;


import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = createList(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode list2 = createList(Arrays.asList(1, 5, 5, 6, 7));
        printList(list1);
        printList(list2);
        ListNode list11 = mergeTwoLists(list1, list2);
        printList(list11);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 =list1;
        ListNode head2 = list2;

        while (list1 != null || list2 != null) {
            if(list1.val < list2.val) {
                var list1NextPosition = list1.next;
                var list2NextPosition = list2.next;
                list2.next = list1;
                list2 = list2NextPosition;

            } else {
                var list1NextPosition = list1.next;
                var list2NextPosition = list2.next;
                list1.next = list2;
                list2.next= list1NextPosition;
                list2 = list2NextPosition;
                list1 = list1NextPosition;
            }
        }
        return list1;
    }

    private static ListNode createList(List<Integer> nums) {
        ListNode head = null;
        for (Integer num : nums) {
            head = addNode(num, head);
        }
        return head;
    }

    private static ListNode addNode(int num, ListNode head) {
        if (head == null) {
            head = new ListNode(num, null);
        } else {
            ListNode lastNode = findLastNode(head);
            lastNode.next = new ListNode(num, null);
        }
        return head;
    }

    private static ListNode findLastNode(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private static void printList(ListNode head) {
        var node = head;
        System.out.println("--------------");
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
