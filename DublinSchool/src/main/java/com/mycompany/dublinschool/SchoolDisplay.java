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
    public void showFileLoaded() {
        System.out.println("\nFile read successfully!");
    }

    // main menu
    public void showMenu() {
        System.out.println("\n------- MENU -------");
        for (Menu option : Menu.values()) {
            System.out.println(option.getNumber() + ". "
                    + option.getDescription());
        }
        System.out.print("\nPlease select: ");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    // The first 20 sorted employees
    public void showSortedEmployees(ArrayList<Employee> employees) {
        System.out.println("\nFirst 20 employees in alphabetical order:");
        for (int i = 0; i < 20 && i < employees.size(); i++) {
            System.out.println((i + 1) + ". "
                    + employees.get(i).getFullName());
        }
    }

    // Employee's full name prompt
    public void showSearchPrompt() {
        System.out.print("\nEnter employee full name: ");
    }

    // employee details
    public void showEmployee(Employee employee) {
        System.out.println("\nEmployee found");
        System.out.println("Name: " + employee.getFullName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Department: " + employee.getDepartment());
    }

    // error messages
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
