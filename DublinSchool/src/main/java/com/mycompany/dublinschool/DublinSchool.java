/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dublinschool;

/**
 *
 * @author sissy
 */
public class DublinSchool {

    public static void main(String[] args) {
        System.out.println("Welcome to Dublin School");

        Employee employee1 = new Employee(
                "Kate",
                "Summer",
                "Female",
                "ksummer@dublinschool.ie",
                112000.00,
                "Management",
                "Principal",
                "School Principal",
                "Dublin School"
        );

        System.out.println("\nEmployee Information:");
        System.out.println("Name: " + employee1.getFullName());
        System.out.println("Position: " + employee1.getPosition());
        System.out.println("Department: " + employee1.getDepartment());

    }
}
