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
    private ArrayList<Employee> newEmployees = new ArrayList<>();

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

    private void addEmployee(Scanner scanner) {
        view.showAddPrompt();
        String fullName = scanner.nextLine().trim();
        while (!fullName.contains(" ")
                || fullName.split("\\s+").length < 2) {

            view.showError("Please enter first and last name.");
            view.showAddPrompt();
            fullName = scanner.nextLine().trim();
        }

        String[] nameParts = fullName.split("\\s+", 2);
        String[] positions = {
            "Principal",
            "Deputy Principal",
            "Teacher",
            "Special Needs Assistant",
            "Support Staff"
        };

        String[] departments = {
            "Management",
            "Teachers",
            "Administration",
            "Student Support",
            "Support Services"
        };

        String position = chooseOption(scanner, "Position", positions);
        String department = chooseOption(scanner, "Department", departments);

        // Create new employee
        Employee employee = new Employee(
                nameParts[0],
                nameParts[1],
                "",
                "",
                0.0,
                department,
                position,
                position,
                "Dublin School"
        );

        employees.add(employee);
        newEmployees.add(employee);

        // keeping employee list sorted
        sortEmployees();

        view.showNewEmployees(newEmployees);
    }

    private String chooseOption(Scanner scanner,
            String title, String[] options) {
        while (true) {
            view.showChoices(title, options);
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                view.showError("Please enter a number");
                continue;
            }
            if (choice >= 1 && choice <= options.length) {
                return options[choice - 1];
            }
            view.showError("Please choose a valid option");
        }
    }

    private void createTree() {
        if (employees.size() < 20) {
            view.showError("At least 20 employees required");
            return;
        }
        BinaryTree tree = new BinaryTree();

        for (Employee employee : employees) {
            tree.insert(employee);
        }

        view.showTree(tree.getLevels(),
                tree.getNodeCount(),
                tree.getHeight());
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
                view.showError("Please enter a valid number");
                continue;
            }

            Menu option = Menu.fromNumber(choice);

            if (option == null) {
                view.showError("Please choose between 1 and 5");
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
                    addEmployee(scanner);
                    break;

                case TREE:
                    createTree();
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
