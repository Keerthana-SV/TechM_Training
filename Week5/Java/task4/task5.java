import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmptyFileChecker {
    // Method to read a file and throw an exception if it's empty
    public static void readFile(String filePath) throws Exception {
        File file = new File(filePath);
        
        if (!file.exists()) {
            throw new FileNotFoundException("Error: File '" + filePath + "' not found!");
        }
        
        if (file.length() == 0) {
            throw new Exception("Error: File '" + filePath + "' is empty!");
        }

        Scanner scanner = new Scanner(file);
        System.out.println("File content:");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            readFile("example.txt"); // Change to your actual file path
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling...");
    }
}
