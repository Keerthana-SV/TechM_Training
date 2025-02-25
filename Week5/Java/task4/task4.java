import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NegativeNumbersOnly {
    // Method to read numbers from a file and throw an exception if any number is positive
    public static void readNumbers(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("Error: File '" + filePath + "' not found!");
        }

        Scanner scanner = new Scanner(file);
        System.out.println("Reading numbers from file:");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println(num);
                if (num > 0) {
                    scanner.close();
                    throw new Exception("Error: Positive number " + num + " found in file!");
                }
            } else {
                scanner.next(); // Skip invalid input
            }
        }

        scanner.close();
        System.out.println("All numbers in the file are non-positive.");
    }

    public static void main(String[] args) {
        try {
            readNumbers("numbers.txt"); // Change to the actual file path
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling...");
    }
}
