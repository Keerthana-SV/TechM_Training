public class TrailingZeroes {
    public static void main(String[] args) {
        int number = 100;
        System.out.println("Trailing zeroes in " + number + "!: " + countTrailingZeroes(number));
    }

    public static int countTrailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
