package com.pluralsight.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    double result;
    char opCode;

    public MathEquation(double leftVal, double rightVal, char opCode){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
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

    }
    void displayResult()
    {
        System.out.println(result);
    }
}
