package ro.siit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatisticsRepositoryTests {
    private  StatisticsRepository sr= new StatisticsRepository();
    private Calculator c=new Calculator();

    public StatisticsRepositoryTests(){

        String s="10.0 cm + 1.0 m - 10.0 mm";
        long start = System.nanoTime();
        c.calculate(s,"mm");
        long end = System.nanoTime();
        long elapsedTime = end - start;
        sr.addEntry(s,elapsedTime/10^6);

        s="10.0 cm + 1.0 m - 10.0 mm - 10 mm + 100 cm";
        start=System.nanoTime();
        c.calculate(s,"mm");
        end=System.nanoTime();
        elapsedTime=end-start;
        sr.addEntry(s,elapsedTime/10^6);

        s="10.0 cm + 1.0 m - 10.0 mm - 10 mm + 10 dm";
        start=System.nanoTime();
        c.calculate(s,"mm");
        end=System.nanoTime();
        elapsedTime=end-start;
        sr.addEntry(s,elapsedTime/10^6);

        s="10.0 cm + 1.0 m - 10.0 mm - 10 mm + 10 cm";
        start=System.nanoTime();
        c.calculate(s,"mm");
        end=System.nanoTime();
        elapsedTime=end-start;
        sr.addEntry(s,elapsedTime/10^6);

        s="10.0 cm + 1.0 m - 10.0 mm - 10 mm + 100 km";
        start=System.nanoTime();
        c.calculate(s,"mm");
        end=System.nanoTime();
        elapsedTime=end-start;
        sr.addEntry(s,elapsedTime/10^6);

        s="10.0 cm + 1.0 m - 10.0 mm - 10 mm + 100 dm";
        start=System.nanoTime();
        c.calculate(s,"mm");
        end=System.nanoTime();
        elapsedTime=end-start;
        sr.addEntry(s,elapsedTime/10^6);
        sr.addEntry("100 m + 100 km", 100000000);
        sr.addEntry("1 mm + 1 mm", 1);

    }

    @Test
    public void totalComputesTest(){
        assertEquals(sr.getNoOfCalculations(),8,0);

    }

    @Test
    public void getLowestComputeTime(){
        assertEquals(sr.getLowestComputeTime(),1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLowestComputeTimeException(){
        StatisticsRepository temp = new StatisticsRepository();
        assertEquals(temp.getLowestComputeTime(),1,0);
    }

    @Test
    public void getHighestComputeTime(){
        assertEquals(sr.getHighestComputeTime(),100000000,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getHighestComputeTimeException(){
        StatisticsRepository temp = new StatisticsRepository();
        assertEquals(temp.getHighestComputeTime(),100000000,0);
    }

    @Test
    public void getLowerComputeTimeThanTests(){
        assertEquals(sr.getNoOfLowerComputeTimesThan(100000000),7,0);
        StatisticsRepository temp = new StatisticsRepository();
        assertEquals(temp.getNoOfLowerComputeTimesThan(1000000000),0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLowerComputeTimeThanExceptionTest(){
        assertEquals(sr.getNoOfLowerComputeTimesThan(-1),7,0);
    }

    @Test
    public void getHigherComputeTimeThanTests(){
        assertEquals(sr.getNoOfHigherComputeTimesThan(1),7,0);
        StatisticsRepository temp = new StatisticsRepository();
        assertEquals(temp.getNoOfHigherComputeTimesThan(1),0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getHigherComputeTimeThanExceptionTest(){
        assertEquals(sr.getNoOfHigherComputeTimesThan(-1),7,0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeByTimeExceptionTests(){
        sr.removeExpressionTime(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeByExpressionExceptionTests(){
        sr.removeExpressionTime("1kmkmkmkmkmkmkkmm");
    }

    @Test
    public void removeByTimeTests(){
        StatisticsRepository temp = new StatisticsRepository();
        temp.addEntry("1 km + 1 km", 200);
        assertEquals(temp.getNoOfCalculations(),1,0);
        temp.removeExpressionTime(200);
        assertEquals(temp.getNoOfCalculations(),0,0);
    }

    @Test
    public void removeByExpressionTests(){
        StatisticsRepository temp = new StatisticsRepository();
        temp.addEntry("1 km + 1 km", 200);
        assertEquals(temp.getNoOfCalculations(),1,0);
        temp.removeExpressionTime("1 km + 1 km");
        assertEquals(temp.getNoOfCalculations(),0,0);
    }
}
