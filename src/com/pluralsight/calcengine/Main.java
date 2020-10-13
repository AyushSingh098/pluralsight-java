package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args){
    double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
    double[] rightVals = {0.0d, 25.0d, 225.0d, 11.0d};
    char[] opCodes = {'d', 'a', 's', 'm'};
    double[] results = new double[opCodes.length];

    for(int index=0;index < opCodes.length;index++)
    {
        switch (opCodes[index]) {
            case 'a':
                results[index] = leftVals[index] + rightVals[index];
                break;
            case 's':
                results[index] = leftVals[index] - rightVals[index];
                break;
            case 'm':
                results[index] = leftVals[index] * rightVals[index];
                break;
            case 'd':
                results[index] = rightVals[index] != 0 ? leftVals[index] / rightVals[index] : 0.0d;
                break;
            default:
                System.out.println("Invalid OpCode");
                results[index] = 0.0d;
                break;
        }
    }

    for(double result: results){
        System.out.println(result);
    }

    }
}
