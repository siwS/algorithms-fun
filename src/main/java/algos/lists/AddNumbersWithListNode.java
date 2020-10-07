package algos.lists;

import java.util.ArrayList;
import java.util.List;

public class AddNumbersWithListNode {

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<Integer>();
        boolean carry_bit = false;

        while (l1 != null || l2 != null) {
            int sum = calculate_sum_for_index(l1, l2);
            if (carry_bit) {
                sum++;
            }

            if (sum < 10) {
                result.add(sum);
                carry_bit = false;
            } else {
                result.add(sum - 10);
                carry_bit = true;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry_bit) {
            result.add(1);
        }

        return convertToListNode(result);
    }

    static ListNode convertToListNode(List<Integer> result) {
        ListNode next = null;
        for (int i = result.size()-1; i >= 0; i--) {
            ListNode current = new ListNode(result.get(i), next);
            next = current;
        }
        return next;
    }

    static int calculate_sum_for_index(ListNode l1, ListNode l2) {
        int value_1 = l1 != null ? l1.val : 0;
        int value_2 = l2 != null ? l2.val : 0;
        return value_1 + value_2;
    }

    static void printListNode(ListNode listNode) {
        while(listNode !=null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
//        ListNode list_1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode list_2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode list_1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode list_2 = new ListNode(9, new ListNode(9, new ListNode(9)));

        ListNode result = addTwoNumbers(list_1, list_2);
        printListNode(result);
    }
}
