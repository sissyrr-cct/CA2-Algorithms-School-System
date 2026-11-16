/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

import java.util.Scanner;

/**
 *
 * @author sissy
 */
public class SchoolController {

    private SchoolDisplay view;

    public SchoolController(SchoolDisplay view) {
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            view.showMenu();

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                view.showError("Please enter a valid number.");
                continue;
            }

            Menu option = Menu.fromNumber(choice);

            if (option == null) {
                view.showError("Please choose between 1 and 5.");
                continue;
            }

            switch (option) {
                case SORT:
                    view.showMessage("Sort");
                    break;

                case SEARCH:
                    view.showMessage("Search");
                    break;

                case ADD:
                    view.showMessage("Add employee");
                    break;

                case TREE:
                    view.showMessage("Binary tree");
                    break;

                case EXIT:
                    view.showMessage("End");
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
}
