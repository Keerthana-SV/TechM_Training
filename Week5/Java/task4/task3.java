import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadExample {
    // Method to read a file and throw an exception if not found
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("Error: File '" + filePath + "' not found!");
        }

        // Reading file content
        Scanner scanner = new Scanner(file);
        System.out.println("File content:");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            readFile("example.txt"); // Change to an existing file path
        } catch (FileNotFoundException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling...");
    }
}
