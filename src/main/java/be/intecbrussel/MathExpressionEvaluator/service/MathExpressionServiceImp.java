package be.intecbrussel.MathExpressionEvaluator.service;

import be.intecbrussel.MathExpressionEvaluator.exception.InvalidExpressionException;

import java.util.Arrays;
import java.util.OptionalInt;

public class MathExpressionServiceImp implements MathExpressionService {

    private BasicMathService basicMathService;
    {
        basicMathService=new BasicMathServiceImpl()
    }

    @Override
    public String evaluate( String expression) {

        if (isInvalidExpression()) {
            throw new InvalidExpressionException("Invalid expression");
        }
        expression = evaluateBrackets(expression);
        expression = evaluateMultiplyAndDivideAndModulo(expression);
        expression = evaluateAddAndSubwtract(expression);
        return expression;
    }


    private String evaluateMultiplyAndDivideAndModulo(String expression) {

        int index;

        while ((index = getLowestMDMIndex(expression)) >= 0) {
            char operator = expression.charAt(index);
            double firstNumber;
            double secondNumber;
            double result;

            switch (operator) {
                case '+':
                   result= basicMathService.multiply(firstNumber,secondNumber);
                    break;
                case '/':
                    result= basicMathService.divide(firstNumber,secondNumber);
                    break;
                case '%':
                    result= basicMathService.modulus(firstNumber,secondNumber);
                    break;
            }
        }
        //           Integer.max(
        //                   Integer.max(expression.indexOf("*"),
        //                           expression.indexOf("/")),
        //                   expression.indexOf("%")
        //           )>=0
        //       &&
        //                   (index= Integer.min(
        //                           Integer.min(expression.indexOf("*"),
        //                   expression.indexOf("/")),
        //                   expression.indexOf("%")
        //                   ))>=0
        //   ){

    }

    private int getLowestMDMIndex(String expression) {
        int[] indices = new int[3];
        indices[0] = expression.indexOf("*");
        indices[1] = expression.indexOf("/");
        indices[2] = expression.indexOf("%");

        OptionalInt first = Arrays.stream(indices)
                .filter(index -> index >= 0)
                .sorted()
                .findFirst();

        int index = first.orElse(-1);
        return index;

    }

    private String evaluateBrackets(String expression) {

        int indexOpenBracket;
        int indexCloseBracket;

        while ((indexOpenBracket = expression.indexOf("(")) >= 0) { // loop for 1 time open and close bracket
            // eerste  wat we doen open hakjes
            // !!!!!!!! int indexOpenBracket = expression.indexOf("(");// first one
            // int indexCloseBracket = expression.indexOf(")"); //  ((2+7/3)+4  tot 4 ,   csifra do scobki
            //int indexCloseBracket = expression.lastIndexOf(")");  //  do imenno scobki ((2+7/3)+4)  // last one
            indexCloseBracket = findCloseBracket(expression, indexOpenBracket);

            if (indexOpenBracket >= 0) {
                //vanaf index open tot close
                String evaluation = evaluate(expression.substring(indexOpenBracket + 1, indexCloseBracket));
                expression = String.valueOf(new StringBuilder(expression)
                                .replace(indexOpenBracket, indexCloseBracket + 1, evaluation))
                        .toString();
            }
        }
        return expression;
    }
}

