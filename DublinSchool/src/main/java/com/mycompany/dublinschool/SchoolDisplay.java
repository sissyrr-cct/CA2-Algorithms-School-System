/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

import java.util.ArrayList;

/**
 *
 * @author sissy
 */
public class SchoolDisplay {

    // welcome message
    public void showWelcome() {
        System.out.println("WELCOME TO DUBLIN SCHOOL - Employee Management System");
    }

    // file read
    public void showFileLoaded(int count) {
        System.out.println("\nFile read successfully!");
        System.out.println("Total employees: " + count);
    }

    // display employee
    public void showFirstEmployee(ArrayList<Employee> employees) {
        System.out.println("\nFirst employee:");
        for (int i = 0; i < 1 && i < employees.size(); i++) {
            
            Employee employee = employees.get(i);

            System.out.println("\nName: " + employee.getFullName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Department: " + employee.getDepartment());
        }
    }

    // error messages
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
