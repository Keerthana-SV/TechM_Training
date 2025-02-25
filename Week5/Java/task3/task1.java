import java.io.File;

public class ListFilesAndDirectories {
    public static void main(String[] args) {
        // Specify the directory path (Change it as per your system)
        String directoryPath ="C:\Dev-Cpp" ; // For Windows
        // String directoryPath = "/home/user/Documents"; // For Linux/Mac

        // Creating a File object for the directory
        File directory = new File(directoryPath);

        // Checking if the path exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            // Getting the list of all files and directories
            String[] fileList = directory.list();

            // Checking if the directory is empty
            if (fileList != null && fileList.length > 0) {
                System.out.println("Files and directories in: " + directoryPath);
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The specified path is not a directory or does not exist.");
        }
    }
}
