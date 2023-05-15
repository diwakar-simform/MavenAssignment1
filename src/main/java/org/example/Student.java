package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Student {

    public void showData(ResultSet rs) {

        System.out.println("ID\t  NAME \t\t\t AGE");
        try {
            while (rs.next()) {
                for (int i = 1; i <= 3; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
        }catch (SQLException s) {
            System.out.println(s.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertData(Statement s){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Age : " );
        String age = sc.next();

        try{
            String sql = "INSERT INTO TraineeData VALUES("+id+",'"+name+"',"+age+")";
            if(s.executeUpdate(sql) > 0){
                System.out.println("-----Data Added-----");
            }
            else{
                System.out.println("-----Data not Added-----");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(Statement s) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Age : ");
        String age = sc.next();
        String query = "UPDATE TraineeData SET name ='"+name+"', age="+age+" WHERE id="+id; // sql query
        if(s.executeUpdate(query) > 0){
            System.out.println("---Updated Successfully---");
        }else{
            System.out.println("----Updation Failed----");
        }

    }

    public void deleteData(Statement s) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID : ");
        int id = sc.nextInt();
        String query = "DELETE FROM TraineeData WHERE id="+id;
        if(s.executeUpdate(query) > 0){
            System.out.println("---Data Deleted---");
        }else{
            System.out.println("---Deletion Failed---");
        }
    }


}
