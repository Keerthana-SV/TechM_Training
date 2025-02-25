package org.example.assignment.corejava.Task6;

import java.util.ArrayList;
import java.util.List;

class task5 {
    public static <T> List<T> mergeAlternating(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int size1 = list1.size(), size2 = list2.size();
        int i = 0, j = 0;

        while (i < size1 || j < size2) {
            if (i < size1) mergedList.add(list1.get(i++)); // Add from first list
            if (j < size2) mergedList.add(list2.get(j++)); // Add from second list
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> intList1 = List.of(1, 3, 5, 7);
        List<Integer> intList2 = List.of(2, 4, 6, 8, 10);
        System.out.println("Merged Integer List: " + mergeAlternating(intList1, intList2));

        List<String> strList1 = List.of("A", "C", "E");
        List<String> strList2 = List.of("B", "D", "F", "G");
        System.out.println("Merged String List: " + mergeAlternating(strList1, strList2));
    }
}
