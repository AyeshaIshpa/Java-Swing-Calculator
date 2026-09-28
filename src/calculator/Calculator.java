package calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    static boolean startNewInput = true;
    static double firstNumber = 0;
    static  String operator = "";

    public static void main(String[] args){
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setText("0");
        display.setEditable(false);

        display.setFont(new Font("Segoe UI", Font.PLAIN,30));

        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel panel= new JPanel();
        panel.setLayout(new GridLayout(4,5,5,5));

        String[] buttons = {
                "7", "8", "9", "/", "⌫",
                "4", "5", "6", "*", "^",
                "1", "2", "3", "-", "%",
                ".", "0", "C", "+", "=",
        };
        for(String text : buttons){
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.PLAIN,18));
            panel.add(button);

            if(text.equals("+")|| text.equals("-")|| text.equals("*")||text.equals("/")){
                button.setBackground(Color.ORANGE);
            } else if(text.equals("=")){
                button.setBackground(Color.BLUE);
            } else if(text.equals("C")){
                button.setBackground(Color.RED);
            } else {
                button.setBackground(Color.LIGHT_GRAY);
            }

            button.addActionListener(e -> {
                        if (text.matches("[0-9]")) {
                            if (display.getText().equals("0") || startNewInput) {

                                display.setText(text);
                                startNewInput = false;
                            } else {
                                display.setText(display.getText() + text);
                            }

                        } else if (text.equals("C")) {

                            display.setText("0");
                            startNewInput = true;
                        } else if (text.equals("+")) {

                            firstNumber = Double.parseDouble(display.getText());

                            operator = "+";

                            startNewInput = true;

                        } else if (text.equals("-")) {

                            firstNumber = Double.parseDouble(display.getText());

                            operator = "-";

                            startNewInput = true;

                        } else if (text.equals("*")) {

                            firstNumber = Double.parseDouble(display.getText());

                            operator = "*";

                            startNewInput = true;

                        } else if (text.equals("/")) {

                            firstNumber = Double.parseDouble(display.getText());

                            operator = "/";

                            startNewInput = true;

                        }else if (text.equals("^")) {
                                firstNumber = Double.parseDouble(display.getText());
                                operator= "^";

                                startNewInput = true;

                        }else if (text.equals("%")) {
                            firstNumber = Double.parseDouble(display.getText());
                            operator= "%";

                            startNewInput = true;

                        } else if (text.equals("=")) {

                            double secondNumber = Double.parseDouble(display.getText());

                            if (operator.equals("+")) {

                                double result = firstNumber + secondNumber;

                                display.setText(String.valueOf(result));

                                startNewInput = true;

                                firstNumber = 0;
                                operator = "";

                            } else if (operator.equals("-")) {

                                double result = firstNumber - secondNumber;

                                display.setText(String.valueOf(result));

                                startNewInput = true;

                                firstNumber = 0;
                                operator = "";

                            } else if (operator.equals("*")) {

                                double result = firstNumber * secondNumber;

                                display.setText(String.valueOf(result));

                                startNewInput = true;

                                firstNumber = 0;
                                operator = "";

                            } else if (operator.equals("/")) {

                                if (secondNumber != 0) {
                                    double result = firstNumber / secondNumber;
                                    display.setText(String.valueOf(result));

                                } else {
                                    display.setText("Error");
                                }


                                startNewInput = true;

                                firstNumber = 0;
                                operator = "";
                            } else if (operator.equals("^")) {
                                double result = Math.pow(firstNumber, secondNumber);

                                display.setText(String.valueOf(result));
                                startNewInput = true;

                                firstNumber = 0;
                                operator = "";
                            }  else if (operator.equals("%")) {
                                double result = firstNumber * secondNumber / 100;

                                display.setText(String.valueOf(result));
                                startNewInput = true;

                                firstNumber = 0;
                                operator = "";

                            }

                        }
                        });
                    }

                    frame.add(panel,BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }
