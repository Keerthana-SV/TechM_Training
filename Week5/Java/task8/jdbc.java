package org.example.assignment.corejava.Task8;

import java.sql.*;
import java.util.Scanner;

public class jdbctasks {
    static String url = "jdbc:mysql://localhost:3306/school";
    static String username = "root";
    static String password = "Pakjesagaslav@25";

    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\tMenu:\t");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select a Row");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        insertRow(con, sc);
                        break;
                    case 2:
                        updateRow(con, sc);
                        break;
                    case 3:
                        deleteRow(con, sc);
                        break;
                    case 4:
                        selectRow(con, sc);
                        break;
                    case 5:
                        System.out.println("Thank You....");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Task 1- Recursively insert multiple row/s into the table.
    public static void insertRow(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the no. of rows to insert: ");
        int n = sc.nextInt();
        sc.nextLine();
        String sql = "insert into school (student_id, student_fname, student_lname, student_age, student_dob) values(?, ?, ?, ?, ?);";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value for id: ");
                String col1 = sc.nextLine();
                System.out.print("Enter value for fname: ");
                String col2 = sc.nextLine();
                System.out.print("Enter value for lname: ");
                String col3 = sc.nextLine();
                System.out.print("Enter value for age: ");
                String col4 = sc.nextLine();
                System.out.print("Enter value for dob: ");
                String col5 = sc.nextLine();
                pstm.setString(1, col1);
                pstm.setString(2, col2);
                pstm.setString(3, col3);
                pstm.setString(4, col4);
                pstm.setString(5, col5);
                pstm.executeUpdate();
            }
            System.out.println(n + " row(s) inserted successfully.");
        }
    }

    //Task 2 : Update the row of a table dynamically using Scanner class.
    public static void updateRow(Connection con, Scanner sc)throws SQLException{
        System.out.print("Enter the ID of the row to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the value for fname: ");
        String value=sc.nextLine();
        String sql="update school set student_fname = ? where student_id=?";
        try(PreparedStatement pstm= con.prepareStatement(sql)){
            pstm.setString(1,value);
            pstm.setInt(2,id);
            int row=pstm.executeUpdate();
            System.out.println(row+" updated!");
        }
    }

    //Task 3 : Delete the row from the table by using a delete query using Scanner class.
    public static void deleteRow(Connection con, Scanner sc) throws SQLException{
        System.out.print("Enter ID of the row to be deleted: ");
        int id=sc.nextInt();
        sc.nextLine();
        String sql="delete from school where student_id=?";
        try(PreparedStatement pstm=con.prepareStatement(sql)){
            pstm.setInt(1,id);
            int row=pstm.executeUpdate();
            System.out.println(row+ " deleted!");
        }
    }

    public static void selectRow(Connection con, Scanner sc) throws SQLException{
        System.out.print("Enter the ID of the row to select: ");
        int id = sc.nextInt();
        sc.nextLine();
        String sql = "select * from school where student_id=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id") + ", Fname: " + rs.getString("student_fname") + ", Lname: " + rs.getString("student_lname"));
            } else {
                System.out.println("No record found with ID: " + id);
            }
        }
    }
}
