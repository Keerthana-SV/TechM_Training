package org.example.assignment.corejava.Task6;

class task1 {
    public static <T> boolean areArraysEqual(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {1, 2, 3, 4, 5};
        Integer[] array3 = {1, 2, 3, 5, 4};

        System.out.println("Array1 and Array2 are equal: " + areArraysEqual(array1, array2)); // true
        System.out.println("Array1 and Array3 are equal: " + areArraysEqual(array1, array3)); // false

        String[] strArray1 = {"apple", "banana", "cherry"};
        String[] strArray2 = {"apple", "banana", "cherry"};
        String[] strArray3 = {"apple", "cherry", "banana"};

        System.out.println("StrArray1 and StrArray2 are equal: " + areArraysEqual(strArray1, strArray2)); // true
        System.out.println("StrArray1 and StrArray3 are equal: " + areArraysEqual(strArray1, strArray3)); // false
    }
}
