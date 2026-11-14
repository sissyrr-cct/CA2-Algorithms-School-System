/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sissy
 */

public class EmployeeFileReader {

    public static ArrayList<Employee> readEmployees(String filename)
            throws IOException {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {
            reader.readLine();
            String line;

            //reading each employee record
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                String[] data = line.split(",", -1);

                if (data.length != 9) {
                    System.out.println("Invalid record skipped.");
                    continue;
                }

                try {
                    Employee employee = new Employee(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            Double.parseDouble(data[4].trim()),
                            data[5].trim(),
                            data[6].trim(),
                            data[7].trim(),
                            data[8].trim()
                    );

                    employees.add(employee);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary skipped.");
                }
            }
        }

        return employees;
    }
}
