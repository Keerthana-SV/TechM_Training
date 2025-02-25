package org.example.assignment.corejava.Task10;

import java.sql.*;
import java.util.Scanner;

public class task1 {
    static String url = "jdbc:mysql://localhost:3306/school";
    static String username = "root";
    static String password = "Pakjesagaslav@25";

    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Scanner sc = new Scanner(System.in)) {            
            //insertRow(con, sc);
            //updateRow(con, sc);
            //deleteRow(con, sc);
            retrieveRow(con, sc);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public static void updateRow(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter the ID of the row to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the value for fname: ");
        String value = sc.nextLine();
        String sql = "update school set student_fname = ? where student_id=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, value);
            pstm.setInt(2, id);
            int row = pstm.executeUpdate();
            System.out.println(row + " row(s) updated!");
        }
    }

    public static void deleteRow(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID of the row to be deleted: ");
        int id = sc.nextInt();
        sc.nextLine();
        String sql = "delete from school where student_id=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            int row = pstm.executeUpdate();
            System.out.println(row + " row(s) deleted!");
        }
    }

    public static void retrieveRow(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter the ID of the row to select: ");
        int id = sc.nextInt();
        sc.nextLine();
        String sql = "select * from school where student_id=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id") + ", Fname: " + rs.getString("student_fname") + ", Age: " + rs.getInt("student_age"));
            } else {
                System.out.println("No record found with ID: " + id);
            }
        }
    }
}
