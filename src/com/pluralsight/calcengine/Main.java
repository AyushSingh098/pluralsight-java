package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args){
    double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
    double[] rightVals = {0.0d, 25.0d, 225.0d, 11.0d};
    char[] opCodes = {'d', 'a', 's', 'm'};
    double[] results = new double[opCodes.length];

    for(int index=0;index < opCodes.length;index++)
    {
        results[index] = execute(opCodes[index], leftVals[index], rightVals[index]);
    }

    for(double result: results){
        System.out.println(result);
    }

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
}
