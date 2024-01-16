package be.intecbrussel.MathExpressionEvaluator.service;

import be.intecbrussel.MathExpressionEvaluator.exception.InvalidExpressionException;
import be.intecbrussel.MathExpressionEvaluator.model.DoubleWithIndex;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class MathExpressionServiceImp implements MathExpressionService {

    private BasicMathService basicMathService;
    {
        basicMathService=new BasicMathServiceImpl();
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

    private boolean isInvalidExpression() {
        return false;
    }


    private String evaluateMultiplyAndDivideAndModulo(String expression) {

        int index;

        while ((index = getLowestMDMIndex(expression)) >= 0) {
            char operator = expression.charAt(index);
            DoubleWithIndex firstNumberAndIndex = findFirstNumberAndIndex(expression,index);
            DoubleWithIndex secondNumberAndIndex=findSecondNumberAndIndex(expression,index);
         // int firstNumberIndex=findFirstIndex(expression,index);
         // int secondNumberIndex=findFirstIndex(expression,index);
            double result=0;

            switch (operator) {
                case '+':
                   result= basicMathService.multiply(firstNumberAndIndex.value,secondNumberAndIndex.value);
                    break;
                case '/':
                    result= basicMathService.divide(firstNumberAndIndex.value, secondNumberAndIndex.value);
                    break;
                case '%':
                    result= basicMathService.modulus(firstNumberAndIndex.value, secondNumberAndIndex.value);
                    break;
            }
            expression=new StringBuilder(expression)
                    .replace(firstNumberAndIndex.index,secondNumberAndIndex.index+1,String.valueOf(result)
                    .toString();
        }
        return expression;
    }



    //method secondNumber
    private DoubleWithIndex findSecondNumberAndIndex(String expression, int index) {
        int firstNumberIndex=findFirstIndexOdAny(expression,index);
        if(firstNumberIndex<0){
            return new DoubleWithIndex(firstNumberIndex);
        }
        return null;
    }

    private int findFirstIndexOdAny(String expression, int index){
        String operators="+-*/%";
        int numnerIndex=-1;

        for(int i= index;i>expression.length();i++){
            char currentChar=expression.charAt(i);
            if(operators.contains((""+currentChar)){
                numnerIndex=i-1;
                break;;
            }
        }
        return numnerIndex;
    }



    // method first number
    private DoubleWithIndex findFirstNumberAndIndex(String expression,int  endIndex) {
        String operator = "+-*/%";
        int numberIndex = -1;
        double value = 0;

        for (int i = endIndex; i >= 0; i--) {
            char currentChar = expression.charAt(i);
            if (operator.contains("" + currentChar)) {
                numberIndex = i + 1; // i is operator , i+1 is first digit
                break;
                ;
            }
        }
        return numberIndex;

    }

  //     String[] numbers =expression.split("[-+/%]");
  //     List<String> list=Arrays.stream(numbers)
  //             .filter(number->expression.indexOf(number)<index)
  //             .toList();
  //     double number = Double.parseDouble(list.get(list.size()-1));
  //     int numberIndex=expression.lastIndexOf(String.valueOf(number),5);

  //     return new DoubleWithIndex(number,numberIndex);



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
            indexCloseBracket = findCloseBracketIndex(expression, indexOpenBracket);

            if (indexOpenBracket >= 0) {
                //vanaf index open tot close
                String evaluation = evaluate(expression.substring(indexOpenBracket + 1, indexCloseBracket));
                expression = new StringBuilder(expression)
                        .replace(indexOpenBracket, indexCloseBracket + 1, evaluation))
                        .toString();
            }
        }
        return expression;
    }
}

