package org.example.assignment.corejava.Task5;

import java.util.Arrays;

class SortThread extends Thread {
    private int[] arr;

    public SortThread(int[] arr) {

        this.arr = arr;
    }

    public int[] getSortedArray() {

        return arr;
    }

    @Override
    public void run() {
        Arrays.sort(arr);
    }
}

public class task3 {
    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,3,4,9,0};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        int mid = arr.length / 2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

        SortThread leftSorter = new SortThread(leftHalf);
        SortThread rightSorter = new SortThread(rightHalf);

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int[] sortedArray = merge(leftSorter.getSortedArray(), rightSorter.getSortedArray());

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            result[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
