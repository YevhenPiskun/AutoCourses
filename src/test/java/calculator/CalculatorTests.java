package calculator;

import com.autocourses.Calculator;
import com.autocourses.WrongEnteringException;
import com.autocourses.WrongOperationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTests {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void shouldAddTwoPositiveNumbers() throws WrongOperationException {
        double a = 100;
        double b = 50;
        String addition = "+";

        //act

        double result = calculator.calculate(a, b, addition);

        assertThat(result).isEqualTo(150);
    }

    @Test
    public void shouldAddOnePositiveAndOneNegativeNumbers() throws WrongOperationException {
        double a = 100;
        double b = -50;
        String addition = "+";

        //act

        double result = calculator.calculate(a, b, addition);

        assertThat(result).isEqualTo(50);
    }

    @Test(expected = WrongOperationException.class)
    public void shouldThrowExceptionIfOperationIsWrong() throws WrongOperationException {
        double a = 200;
        double b = 100;
        String addition = "#";

        calculator.calculate(a, b, addition);
    }

    @Test
    public void shouldThrowExceptionIfOperationIsWrong2() {
        double a = 200;
        double b = 100;
        String addition = "#";

        assertThatThrownBy(() -> calculator.calculate(a, b, addition)).isInstanceOf(WrongOperationException.class);
    }

    @Test
    public void shouldAddTwoNegativeNumbers() throws WrongOperationException {
        double a = -100;
        double b = -200;
        String addition = "+";
        double result = calculator.calculate(a, b, addition);

        assertThat(result).isEqualTo(-300);
    }

}
