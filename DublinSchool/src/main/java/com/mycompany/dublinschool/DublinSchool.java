/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dublinschool;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sissy
 */
public class DublinSchool {

    public static void main(String[] args) {
        System.out.println("WELCOME TO DUBLIN SCHOOL - Employee Management System");

        try {
            ArrayList<Employee> employees
                    = EmployeeFileReader.readEmployees("Applicants_Form.txt");

            System.out.println("\nFile read successfully!");
            System.out.println("Total employees: " + employees.size());

            System.out.println("\nFirst employee:");

            for (int i = 0; i < 1 && i < employees.size(); i++) {

                Employee employee = employees.get(i);

                System.out.println("\nName: " + employee.getFullName());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Department: " + employee.getDepartment());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
