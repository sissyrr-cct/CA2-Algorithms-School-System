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
        SchoolDisplay view = new SchoolDisplay();
        view.showWelcome();

        try {
            ArrayList<Employee> employees =
                    EmployeeFileReader.readEmployees("Applicants_Form.txt");

            view.showFileLoaded();
            SchoolController controller = new SchoolController(view, employees);
            controller.start();
            
        } catch (IOException e) {
            view.showError(e.getMessage());
        }
    }
}