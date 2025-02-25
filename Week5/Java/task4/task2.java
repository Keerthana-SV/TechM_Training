public class OddNumberExceptionExample {
    
    public static void checkEvenNumber(int num) throws Exception {
        if (num % 2 != 0) {
            throw new Exception("Error: " + num + " is an odd number!");
        }
        System.out.println(num + " is an even number.");
    }

    public static void main(String[] args) {
        try {
            checkEvenNumber(10); // Even number (No exception)
            checkEvenNumber(7);  // Odd number (Throws exception)
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling...");
    }
}
