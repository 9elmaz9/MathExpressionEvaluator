package be.intecbrussel.MathExpressionEvaluator;

//import org.junit.jupiter.api.Assertions;

public class MathApp {
    public static void main(String[] args) {
        //Assertions assertions;

        int a= 1_000_000_000;
        int b=2_000_000_000;
        int c= a + b;
        System.out.println(c); // we hebben hier overflow
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+(long)12949672989979808L);


    }
}
