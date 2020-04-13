package ro.siit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTests
{
    Calculator c = new Calculator();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void calculateTestsWorking()
    {

        float result=0;

            result=c.calculate("10.0 cm + 1.0 m - 10.0 mm","mm");
            Assert.assertTrue(result==1090);


            result=c.calculate("10 cm + 2 m - 10 mm","mm");
            Assert.assertTrue(result==2090);


            result=c.calculate("20 cm + 1 m - 10 mm","mm");
            Assert.assertTrue(result==1190);


            result=c.calculate("10 cm + 1 m - 10 mm","mm");
            Assert.assertTrue(result==1090);


    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTestsExceptions1(){
        c.calculate("20 cm + 1 m - 10 mm","mlm");
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateTestsExceptions2(){
        c.calculate("20 cm + ","mm");
    }


    @Test(expected = IllegalArgumentException.class)
    public void calculateTestsExceptions3(){
        c.calculate("20 ckm + 1 m - 10 mm","mm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTestsExceptions4(){
        c.calculate("2a0 cm + 1 m - 10 mm","mm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTestsExceptions5(){
        c.calculate("20 cm * 1 m - 10 mm","mm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTestsExceptions6(){
        c.calculate("20 cm + 1 m - mm","mm");
    }

    @Test
    public void additionTests(){
        float i=0;

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*10,c.addition(10,i,"cm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*100,c.addition(10,i,"dm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*1000,c.addition(10,i,"m"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*1000000,c.addition(10,i,"km"),0);
        }
    }

    @Test
    public void substractTestsWorking(){
        float i=0;

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*10,c.addition(10,i,"cm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*100,c.addition(10,i,"dm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*1000,c.addition(10,i,"m"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(10+i*1000000,c.addition(10,i,"km"),0);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void finalConvertTestsExceptions(){
        c.convertForOutput(10,"jkm");
        c.convertForOutput(10,"jkaaaam");
    }

    @Test
    public void finalConvertTestsWorking(){
        float i=0;

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*1000000 + 1;
            Assert.assertEquals(i,c.convertForOutput(i,"mm"),0);
        }
        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*1000000 + 1;
            Assert.assertEquals(i/10,c.convertForOutput(i,"cm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*1000000 + 1;
            Assert.assertEquals(i/100,c.convertForOutput(i,"dm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*1000000 + 1;
            Assert.assertEquals(i/1000,c.convertForOutput(i,"m"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*1000000 + 1;
            Assert.assertEquals(i/1000000,c.convertForOutput(i,"km"),0);
        }

    }

    @Test
    public void convertToMMTests(){
        float i=0;

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(i*10,c.convertToMm(i,"cm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(i*100,c.convertToMm(i,"dm"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(i*1000,c.convertToMm(i,"m"),0);
        }

        for(int j=0;j<10;j++)
        {
            i=(float)Math.random()*100 + 1;
            Assert.assertEquals(i*1000000,c.convertToMm(i,"km"),0);
        }
    }

}
