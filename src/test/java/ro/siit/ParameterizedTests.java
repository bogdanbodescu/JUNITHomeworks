package ro.siit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTests {
    private float inputNumber;
    private float expectedResult;
    private String metrical;


    public ParameterizedTests(float inputNumber,String metrical, float expectedResult){
        this.inputNumber=inputNumber;
        this.metrical=metrical;
        this.expectedResult=expectedResult;
    }

    @Parameterized.Parameters
    public static Collection mmNumbers() {
        return Arrays.asList(new Object[][] {
                { 100, "m",100000 },
                { 100, "cm",1000 },
                { 100, "dm",10000 },
                { 1, "km",1000000 }
        });
    }

    @Test
    public void testingConversionToMM(){
        Calculator c = new Calculator();
        assertEquals(c.convertToMm(this.inputNumber,this.metrical),this.expectedResult,0);
    }
}
