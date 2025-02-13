public class PrimitiveReferenceDemo {
    public static void main(String[] args) {
        int num = 10;
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Before method call:");
        System.out.println("num: " + num);
        System.out.print("array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        modify(num, array);

        System.out.println("After method call:");
        System.out.println("num: " + num);
        System.out.print("array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    static void modify(int n, int[] arr) {
        n = 20;
        arr[0] = 99;
    }
}
