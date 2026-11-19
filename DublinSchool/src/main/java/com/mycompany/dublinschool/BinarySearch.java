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
public class BinarySearch {
    public static int binarySearch(ArrayList<Employee> arr,
            int low, int high, String name) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int comparison = name.compareToIgnoreCase(
                arr.get(mid).getFullName());

        if (comparison == 0) {
            return mid;

        } else if (comparison < 0) {
            return binarySearch(arr, low, mid - 1, name);

        } else {
            return binarySearch(arr, mid + 1, high, name);
        }
    }
}