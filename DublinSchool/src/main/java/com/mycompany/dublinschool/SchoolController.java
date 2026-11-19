/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author sissy
 */
public class SchoolController {

    private SchoolDisplay view;
    private ArrayList<Employee> employees;

    public SchoolController(SchoolDisplay view, ArrayList<Employee> employees) {
        this.view = view;
        this.employees = employees;
    }
    
    private void sortEmployees() {
        Employee[] arr = employees.toArray(new Employee[0]);

        // recursive Merge Sort
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            employees.set(i, arr[i]);
        }
    }
    
     private void searchEmployee(Scanner scanner) {
        view.showSearchPrompt();
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            view.showError("Please enter a name");
            return;
        }
        sortEmployees();
        int index = BinarySearch.binarySearch(
                employees, 0, employees.size() - 1, name);
        if (index == -1) {
            view.showMessage("Employee not found");
        } else {
            view.showEmployee(employees.get(index));
        }
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
                    sortEmployees();
                    view.showSortedEmployees(employees);
                    break;

                case SEARCH:
                    searchEmployee(scanner);
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
