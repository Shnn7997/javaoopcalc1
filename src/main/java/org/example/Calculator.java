
package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.IOException;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOGGING_PROPERTIES = "/logging.properties";

    static {
        try {
            LogManager.getLogManager().readConfiguration(Calculator.class.getResourceAsStream(LOGGING_PROPERTIES));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load logging configuration: " + e.getMessage());
            throw new RuntimeException("Failed to load logging configuration");
        }
    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
        try {
            LogManager.getLogManager().readConfiguration(Calculator.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load logging configuration: " + e.getMessage());
            throw new RuntimeException("Failed to load logging configuration");
        }
        while (true) {
            displayMenu();
            int choice = getChoice();
            if (choice == 1) {
                performRationalOperation();
            } else if (choice == 2) {
                performComplexOperation();
            } else if (choice == 3) {
                logger.log(Level.INFO, "Exiting calculator");
                break;
            } else {
                logger.log(Level.SEVERE, "Invalid choice: " + choice);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Calculator Menu:");
        System.out.println("1. Rational Numbers");
        System.out.println("2. Complex Numbers");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void performRationalOperation() {
        System.out.print("Enter the first rational number (numerator/denominator): ");
        String[] parts1 = scanner.nextLine().split("/");
        if (parts1.length != 2) {
            System.out.println("Invalid input!");
            logger.log(Level.WARNING, "Invalid rational number input: " + parts1);
            return;
        }
        RationalNumber num1 = new RationalNumber(Integer.parseInt(parts1[0]), Integer.parseInt(parts1[1]));
        System.out.print("Enter the second rational number (numerator/denominator): ");
        String[] parts2 = scanner.nextLine().split("/");
        if (parts2.length != 2) {
            System.out.println("Invalid input!");
            logger.log(Level.WARNING, "Invalid rational number input: " + parts2);
            return;
        }
        RationalNumber num2 = new RationalNumber(Integer.parseInt(parts2[0]), Integer.parseInt(parts2[1]));
        System.out.print("Enter the operation (+, -, *, /): ");
        String operation = scanner.nextLine();
        Number result = null;
        switch (operation) {
            case "+":
                result = num1.add(num2);
                break;
            case "-":
                result = num1.subtract(num2);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "/":
                result = num1.divide(num2);
                break;
            default:
                System.out.println("Invalid operation!");
                logger.log(Level.WARNING, "Invalid operation: " + operation);
                return;
        }
        System.out.println("Result: " + result.toString());
        logger.log(Level.INFO, "Performed rational operation: " + num1 + " " + operation + " " + num2 + " = " + result);
    }


    private static void performComplexOperation() {
        System.out.print("Enter the first complex number (real part, imaginary part): ");
        String[] parts1 = scanner.nextLine().split(",");
        if (parts1.length != 2) {
            System.out.println("Invalid input!");
            logger.log(Level.WARNING, "Invalid complex number input: " + parts1);
            return;
        }
        ComplexNumber num1 = new ComplexNumber(Double.parseDouble(parts1[0]), Double.parseDouble(parts1[1]));
        System.out.print("Enter the second complex number (real part, imaginary part): ");
        String[] parts2 = scanner.nextLine().split(",");
        if (parts2.length != 2) {
            System.out.println("Invalid input!");
            logger.log(Level.WARNING, "Invalid complex number input: " + parts2);
            return;
        }
        ComplexNumber num2 = new ComplexNumber(Double.parseDouble(parts2[0]), Double.parseDouble(parts2[1]));
        System.out.print("Enter the operation (+, -, *, /): ");
        String operation = scanner.nextLine();
        Number result = null;
        switch (operation) {
            case "+":
                result = num1.add(num2);
                break;
            case "-":
                result = num1.subtract(num2);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "/":
                result = num1.divide(num2);
                break;
            default:
                System.out.println("Invalid operation!");
                logger.log(Level.WARNING, "Invalid operation: " + operation);
                return;
        }
        System.out.println("Result: " + result.toString());
        logger.log(Level.INFO, "Performed complex operation: " + num1 + " " + operation + " " + num2 + " = " + result);
    }
}