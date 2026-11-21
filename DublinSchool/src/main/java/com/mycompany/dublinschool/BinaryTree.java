/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dublinschool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author sissy
 */
public class BinaryTree {
    // one employee per node
    private class Node {
        Employee employee;
        Node left;
        Node right;

        Node(Employee employee) {
            this.employee = employee;
        }
    }

    private Node root;
    private int nodeCount = 0;
    
    // level-order
    public void insert(Employee employee) {
        Node newNode = new Node(employee);
        nodeCount++;
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // level-order traversal
    public ArrayList<ArrayList<Employee>> getLevels() {
        ArrayList<ArrayList<Employee>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Employee> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                Node current = queue.remove();
                level.add(current.employee);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public int getHeight() {
        return getLevels().size();
    }
}
