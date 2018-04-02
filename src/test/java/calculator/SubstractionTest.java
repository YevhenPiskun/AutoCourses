package calculator;

import com.autocourses.Calculator;
import com.autocourses.WrongOperationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SubstractionTest {
    private double firstNum;
    private double secondNum;
    private double result;
    private Calculator calculator;

    public SubstractionTest(double firstNum, double secondNum, double result) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getInputData() {
        return new Object[][]
                {
                        {200, 100, 100},
                        {100, -200, 300},
                        {-100, -200, 100}
                };
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void shouldCheckSubstraction() throws WrongOperationException {
        Assert.assertEquals(result, calculator.calculate(firstNum, secondNum, "-"), 0.0001);
    }

    @Test(expected = WrongOperationException.class)
    public void shouldReturnWrongOperationException() throws WrongOperationException {
        double a = 200;
        double b = 300;
        String substraction = "%";

        calculator.calculate(a, b, substraction);
    }

}
