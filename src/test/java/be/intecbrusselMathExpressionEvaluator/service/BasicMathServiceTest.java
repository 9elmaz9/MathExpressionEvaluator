package be.intecbrusselMathExpressionEvaluator.service;

import be.intecbrussel.MathExpressionEvaluator.service.BasicMathService;
import be.intecbrussel.MathExpressionEvaluator.service.BasicMathServiceImpl;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasicMathServiceTest {
    private BasicMathService basicMathService;
    //we gaan hier anotatie gebruiken

    @BeforeAll  // which will run once
    public  void beforeAll(){
        //TODO instantiate  the service
        basicMathService=new BasicMathServiceImpl();
    }

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
        double result = basicMathService.add(firstNumber, secondNumber);

        Assertions.assertEquals(expectedValue,result);
    }
}
