package be.intecbrussel.MathExpressionEvaluator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicMathServiceImpl implements BasicMathService {
    @Override
    public double add(double firstNumber, double secondNumber) {
        BigDecimal firstDecimal = convertDoubleToBigDecimal(firstNumber);
        BigDecimal secondDecimal = convertDoubleToBigDecimal(secondNumber);

        BigDecimal result = firstDecimal.add(secondDecimal);

        return result.doubleValue();

        /*  alles werk
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
        BigDecimal firstDecimal = convertDoubleToBigDecimal(firstNumber);
        BigDecimal secondDecimal = convertDoubleToBigDecimal(secondNumber);

        BigDecimal result = firstDecimal.subtract(secondDecimal);

        return result.doubleValue();

/* correct - maar lang
        String firstNumberAsString=String.valueOf(firstNumber);
        String secondNumberAsString=String.valueOf(secondNumber);

        BigDecimal firstDecimal = new BigDecimal(String.valueOf(firstNumber));
        BigDecimal secondDecimal = new BigDecimal(String.valueOf(secondNumber));

        BigDecimal result = firstDecimal.subtract(secondDecimal);

        return result.doubleValue();
*/
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {
        String firstNumberAsString = String.valueOf(firstNumber);
        String secondNumberAsString = String.valueOf(secondNumber);

        BigDecimal firstDecimal = new BigDecimal(String.valueOf(firstNumber));
        BigDecimal secondDecimal = new BigDecimal(String.valueOf(secondNumber));

        BigDecimal result = firstDecimal.multiply(secondDecimal);

        return result.doubleValue();

    }

    @Override
    public double divide(double dividend, double divider) {

        BigDecimal firstDecimal = convertDoubleToBigDecimal(dividend);
        BigDecimal secondDecimal = convertDoubleToBigDecimal(divider);

        BigDecimal result = firstDecimal.divide(secondDecimal,10, RoundingMode.HALF_UP);

        return result.doubleValue();

    }
      private BigDecimal convertDoubleToBigDecimal(double number){
          String numberAsString=String.valueOf(number);
          return new BigDecimal(numberAsString);
        }

 // it is correct work too / another method
 //     if(divider==0){
 //         System.out.println("Error");
 //         throw new ArithmeticException("can't be divided by ZERO");
 //     }
 //  // String firstDividendAsString = String.valueOf( dividend);
 //  // String secondDividendAsString = String.valueOf(divider);
 //     BigDecimal firstDecimal =  BigDecimal.valueOf(dividend);
 //     BigDecimal secondDecimal =  BigDecimal.valueOf(divider);
 //     BigDecimal result = firstDecimal.divide(secondDecimal,10,BigDecimal.ROUND_HALF_UP);
 //     return result.doubleValue();


    @Override
    public double modulus(double firstNumber, double secondNumber) {
        return firstNumber % secondNumber;
    }


  //    if(secondNumberDivider<0||secondNumberDivider>100){
  //        throw new IllegalArgumentException("% only 0-100");
  //    }
  //    String firstNumberAsString= String.valueOf(firstNumberDividend);
  //    String secondNumberAsString = String.valueOf(secondNumberDivider);


  //    BigDecimal firstDecimal = new BigDecimal(String.valueOf(firstNumberDividend));
  //    BigDecimal secondDecimal = new BigDecimal(String.valueOf(secondNumberDivider));

  //   // BigDecimal result = firstDecimal.divide(secondDecimal);
  //    BigDecimal result = BigDecimal.valueOf(firstNumberDividend%secondNumberDivider);

  //    return result.doubleValue();
  //    //return  calculateMo;
    }

