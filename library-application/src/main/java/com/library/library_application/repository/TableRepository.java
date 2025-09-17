package com.library.library_application.repository;
import com.library.config.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

    public class TableRepository {


        public void createBooksTable(Connection conn) {
            String sql = "CREATE TABLE IF NOT EXISTS books (" +
                    "book_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "author VARCHAR(255) NOT NULL, " +
                    "available_status BOOLEAN DEFAULT TRUE" +
                    ")";
            executeSQL(conn, sql, "Books table created successfully.");
        }


        public void createMembersTable(Connection conn) {
            String sql = "CREATE TABLE IF NOT EXISTS members (" +
                    "member_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) UNIQUE NOT NULL" +
                    ")";
            executeSQL(conn, sql, "Members table created successfully.");
        }


        public void createLoansTable(Connection conn) {
            String sql = "CREATE TABLE IF NOT EXISTS loans (" +
                    "loan_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "book_id INT NOT NULL, " +
                    "member_id INT NOT NULL, " +
                    "loan_date DATE NOT NULL, " +
                    "return_date DATE, " +
                    "FOREIGN KEY (book_id) REFERENCES books(book_id), " +
                    "FOREIGN KEY (member_id) REFERENCES members(member_id)" +
                    ")";
            executeSQL(conn, sql, "Loans table created successfully.");
        }

        // Helper method to execute SQL queries
        private void executeSQL(Connection conn, String sql, String successMessage) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
                System.out.println(successMessage);
            } catch (SQLException e) {
                System.out.println("Error creating table: " + e.getMessage());
            }
        }


            public static void main(String[] args) {
                try (Connection conn = DBConnection.getConnection()) {
                    TableRepository repo = new TableRepository();

                    repo.createBooksTable(conn);
                    repo.createMembersTable(conn);
                    repo.createLoansTable(conn);

                } catch (SQLException e) {
                    System.out.println("Connection failed: " + e.getMessage());
                }
            }

    }
