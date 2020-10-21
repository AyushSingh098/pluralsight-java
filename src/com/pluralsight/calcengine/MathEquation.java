package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private double result;
    private char opCode;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation(char opCode){
        this.opCode = opCode;
    }
    public MathEquation(double leftVal, double rightVal, char opCode){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;

    }

    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }
    void execute(){
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
        numberOfCalculations++;
        sumOfResults += result;

    }
    void displayResult()
    {
        System.out.println(result);
    }

    public static double getAverageResult(){
        return sumOfResults/numberOfCalculations;
    }



}
