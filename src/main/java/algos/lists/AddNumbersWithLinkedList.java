package algos.lists;

import java.util.LinkedList;
import java.util.List;

public class AddNumbersWithLinkedList {

    static List addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int digits = Math.max(l1.size(), l2.size());
        List<Integer> result = new LinkedList<>();
        boolean carryBit = false;

        for (int i = 0; i < digits; i++) {
            int sum = calculate_sum_for_index(l1, l2, i, carryBit);

            if (sum < 10) {
                result.add(sum);
                carryBit = false;
            } else {
                result.add(sum - 10);
                carryBit = true;
            }
        }

        if (carryBit) {
            result.add(1);
        }

        return result;
    }

    static int calculate_sum_for_index(LinkedList<Integer> l1, LinkedList<Integer> l2, int index, boolean carryBit) {
        int number_1 = index < l1.size() ? l1.get(index) : 0;
        int number_2 = index < l2.size() ? l2.get(index) : 0;
        number_2 = carryBit ? number_2 + 1 : number_2;

        return number_1 + number_2;
    }

    public static void main(String[] args) {
        LinkedList list_1 = new LinkedList<Integer>();
        for (int i = 0; i < 7; i++) {
            list_1.add(9);
        }

        LinkedList list_2 = new LinkedList<Integer>();
        for (int i = 0; i < 4; i++) {
            list_2.add(9);
        }

        System.out.println(addTwoNumbers(list_1, list_2));
    }
}

