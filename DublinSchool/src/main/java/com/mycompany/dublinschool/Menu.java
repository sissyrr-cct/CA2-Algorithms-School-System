/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

/**
 *
 * @author sissy
 */
public enum Menu {

    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD(3, "Add Employee"),
    TREE(4, "Create Binary Tree"),
    EXIT(5, "Exit");

    private final int number;
    private final String description;

    Menu(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static Menu fromNumber(int number) {
        for (Menu option : Menu.values()) {
            if (option.getNumber() == number) {
                return option;
            }
        }
        return null;
    }
}
