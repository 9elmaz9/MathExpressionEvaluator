package be.intecbrusselMathExpressionEvaluator.service;

import be.intecbrussel.MathExpressionEvaluator.service.BasicMathService;
import be.intecbrussel.MathExpressionEvaluator.service.BasicMathServiceImpl;
import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasicMathServiceTest {
    // private BasicMathService basicMathService;
    //we gaan hier anotatie gebruiken

    //public class BasicMathServiceTest{
    private final BasicMathService basicMathService;

    {
        this.basicMathService = new BasicMathServiceImpl();
    }

    //@BeforeAllpublic static void setup(){}

    //  @BeforeAll   which will run once
    //public  void beforeAll(){
    //TODO instantiate  the service
    // basicMathService=new BasicMathServiceImpl();
//}

    //verscheel - 1 test, voor elke test
    //which will run before every test, so it can reset the conditions for the next one.
    // @BeforeEach(){

    //that this is an executable test method
    @Test
    //@Disabled
    public void testBasicAdditionOfTwoIntegers() {

        int firstNumber = 7;
        int secondNumber = 6;

        int expectedValue = 13;
        //ALS
        //int expectedValue = 14;
        //org.opentest4j.AssertionFailedError:
        //Expected :14.0
        //Actual   :13.0
        double result = basicMathService.add(firstNumber, secondNumber); // we willen testen deze

        Assertions.assertEquals(expectedValue, result);
    }

    // new*
    @Test
    public void testBasicAddictionOfTwoNegativeIntegers() {
        int firstNumber = -4;
        int secondNumber = -8;

        int expectedResult = -12;

        double result = basicMathService.add(firstNumber, secondNumber);

        Assertions.assertEquals(expectedResult, result);
    }


    //new3
    @ParameterizedTest
    //@ValueSourse({1,2,3,4}) // hier we moete anotatie ezelf schrijf
    @MethodSource("basicAdditionFactory")
    public void testBasicAdditions(double number1, double number2, double expectedValue) {
        double result = basicMathService.add(number1, number2);
        Assertions.assertEquals(expectedValue, result); // tonen resulr
    }


    public static Stream<Arguments> basicAdditionFactory() {
        //return null;
        return Stream.of(
                Arguments.of(5, 3, 8),
                Arguments.of(50, 3, 53),
                Arguments.of(-5, 3, -2),
                Arguments.of(0, 0, 0),
                Arguments.of(-7, -3, -10),
                Arguments.of(5.5, 4.5, 10),
                Arguments.of(2000000000, 2000000000, 4000000000L),
                Arguments.of(-0.00001, 0.00002, 0.00001),
                Arguments.of(0.99999, 0.000001, 0.999991)
        );

    }
}