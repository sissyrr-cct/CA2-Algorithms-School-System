/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

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

    // error messages
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
