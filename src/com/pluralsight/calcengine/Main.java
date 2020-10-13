package com.pluralsight.calcengine;

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
    else
    {
        System.out.println("Error");
    }

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
}
