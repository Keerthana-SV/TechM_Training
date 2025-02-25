import java.util.*;
import java.util.Arrays;

public class StudentMarks {
    // Task 2: Accept Students' Names and Marks, Calculate Total, Average, and Sort
    public static void studentMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        String[][] students = new String[n][3];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            students[i][0] = scanner.nextLine();
            System.out.print("Enter marks (comma-separated): ");
            String[] marks = scanner.nextLine().split(",");
            int total = Arrays.stream(marks).mapToInt(Integer::parseInt).sum();
            double average = (double) total / marks.length;
            students[i][1] = String.valueOf(total);
            students[i][2] = String.valueOf(average);
        }
        
        Arrays.sort(students, (a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));
        
        System.out.println("Sorted Student List:");
        for (String[] student : students) {
            System.out.println(student[0] + " - Total: " + student[1] + ", Average: " + student[2]);
        }
    }

    public static void main(String[] args) {
        studentMarks();
    }
}
