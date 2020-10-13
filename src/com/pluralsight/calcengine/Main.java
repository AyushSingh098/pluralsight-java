package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
    if(args.length ==0) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {0.0d, 25.0d, 225.0d, 11.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        for (int index = 0; index < opCodes.length; index++) {
            results[index] = execute(opCodes[index], leftVals[index], rightVals[index]);
        }

        for (double result : results) {
            System.out.println(result);
        }
    }
    else if(args.length ==3)
    {
        handleCommandLine(args);
    }
    else if(args.length ==1 && args[0].equals("interactive"))
    {
        executeInteractively();
    }
    else {
        System.out.println("Error");
    }
    }

    static void executeInteractively(){
        System.out.println("Enter and operation and two number");
        Scanner scanner = new Scanner(System.in);
        String userInput= scanner.nextLine();
        String[] parts= userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result=0.0d;
        result = execute(opCode,leftVal,rightVal);
        displayResult(opCode, leftVal,rightVal, result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder sb = new StringBuilder();
        sb.append(leftVal);
        sb.append(symbol);
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);
        String displayResult=sb.toString();
        System.out.println(displayResult);
    }

    private static char symbolFromOpCode(char opCode){
        char[] opCodes = {'d', 'a', 's', 'm'};
        char[] symbols={'/', '+', '-', '*'};
        char symbol = ' ';
        for(int index=0;index <opCodes.length;index++){
            if(opCode == (opCodes[index]))
            {
                symbol = symbols[index];
                break;
            }
        }

        return symbol;

    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result;
        result  =execute(opCode,leftVal,rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal){
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid OpCode");
                result = 0.0d;
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName){
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word){
        String[] numberWords = {"zero","one", "two", "three", "four",
                                "five", "six", "seven", "eight", "nine"};
        double value =0.0d;
        for(int index=0;index <numberWords.length;index++){
            if(word.equals(numberWords[index]))
            {
                value = index;
                break;
            }
        }

        return value;
    }
}
