package com.example;

// Import necessary libraries and controls
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

// Main class 
public class PrimaryController {

    // Connect this code with the elements defined in the FXML file
    @FXML 
    // Define the text fields for input two numbers and a label to store the result
    private TextField num1Field, num2Field;
    @FXML
    private Label resultLabel;

    @FXML
    // Sum Method
    private void calculateSum() {
        calculate((a, b) -> a + b);
    }

    @FXML
    // Subtraction Method
    private void calculateSubtraction() {
        calculate((a, b) -> a - b);
    }

    @FXML
    // Multiplication Method
    private void calculateMultiplication() {
        calculate((a, b) -> a * b);
    }

    @FXML
    // Division Method
    private void calculateDivision() {
        calculate((a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        });
    }

    // Calculate the result based on the operation chosen
    private void calculate(Calculator calculator) {
        try {
            if (num1Field.getText().isEmpty() || num2Field.getText().isEmpty()) {
                resultLabel.setText("Please fill in both fields");
                return;
            }
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = calculator.calculate(num1, num2);
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input - please enter a number");
        } catch (ArithmeticException e) {
            resultLabel.setText(e.getMessage());
        }
    }

    // Define the calculate method
    @FunctionalInterface
    interface Calculator {
        double calculate(double a, double b);
    }
}
