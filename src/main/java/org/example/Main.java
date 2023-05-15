package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    // Main method
    public static void main(String[] args) {
        Student s1 = new Student();
        DbConnection con1 = new DbConnection();
        String showQuery = "SELECT * FROM TraineeData"; // sql query

        Scanner sc = new Scanner(System.in);
        Boolean b = true;
        while(b){


        System.out.println("\nPlease Enter your choice : \n1.Show Data\n2.Insert Data\n3.Update Data\n4.deleteQuery\n5.exit");
        int choice = sc.nextInt();

        switch (choice){
            case 1 :
                try {

                    Connection con = con1.connectToDb(); // obtain a connection
                    Statement st = con.createStatement(); // Obtain a statement
                    ResultSet rs = st.executeQuery(showQuery); // Execute the query
                    s1.showData(rs); // displays all data from database
                    con.close();
                }catch (ClassNotFoundException c) {
                    System.out.println(c.getMessage());
                }catch (SQLException s) {
                    System.out.println(s.getMessage());
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2 :
                try{
                    Connection con = con1.connectToDb(); // obtain a connection
                    Statement st = con.createStatement(); // Obtain a statement
                    s1.insertData(st); // insert data into table
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3 :
                try {

                    Connection con = con1.connectToDb(); // obtain a connection
                    Statement st = con.createStatement(); // Obtain a statement
                    s1.updateData(st);
                }catch (ClassNotFoundException c) {
                    System.out.println(c.getMessage());
                }catch (SQLException s) {
                    System.out.println(s.getMessage());
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4 :
                try {

                    Connection con = con1.connectToDb(); // obtain a connection
                    Statement st = con.createStatement(); // Obtain a statement
                    s1.deleteData(st);

                }catch (ClassNotFoundException c) {
                    System.out.println(c.getMessage());
                }catch (SQLException s) {
                    System.out.println(s.getMessage());
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5 : b = false;
                     break;

            default :
                System.out.println("please enter a valid input..");
        }
        }
    }
}
