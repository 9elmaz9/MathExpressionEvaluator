package be.intecbrussel.MathExpressionEvaluator.service;

import java.math.BigDecimal;

public class BasicMathServiceImpl implements BasicMathService {
    @Override
    public double add(double firstNumber, double secondNumber) {
        //vb3


        String firstNumberAsString=String.valueOf(firstNumber);
        String secondNumberAsString=String.valueOf(secondNumber);


        BigDecimal firstDecimal = new BigDecimal(String.valueOf(firstNumber));
        BigDecimal secondDecimal = new BigDecimal(String.valueOf(secondNumber));

        BigDecimal result = firstDecimal.add(secondDecimal);

      // System.out.println(firstDecimal);
      // System.out.println(secondDecimal);
      // System.out.println(result);
        return result.doubleValue();


        //1 vb
        // return firstNumber+secondNumber;  //default was 0
        // return firstNumber+firstNumber;  //error

   /*     //Jonathan brain activated ; vb2
        int amountOfNumbersBeforeDecimal1 = String.valueOf((int) firstNumber).length();
        int amountOfNumbersBeforeDecimal2 = String.valueOf((int) secondNumber).length();
        int mostDecimals = Integer.max(amountOfNumbersBeforeDecimal1, amountOfNumbersBeforeDecimal2);
        int theJonathanNumber = 10;
        for (int i = 0; i < mostDecimals; i++) {
            theJonathanNumber *= 10;
        }
        double jonathan1 = firstNumber + theJonathanNumber;
        double jonathan2 = secondNumber * theJonathanNumber;
        double jonathanResult = jonathan1 + jonathan2;
        double realResult = jonathanResult / theJonathanNumber;
        return realResult; */
    }

    @Override
    public double subtract(double firstNumber, double secondNumber) {
        return 0;
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {
        return 0;
    }

    @Override
    public double divide(double dividend, double divider) {
        return 0;
    }
}
