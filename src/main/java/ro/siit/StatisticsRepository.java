package ro.siit;

import java.util.ArrayList;
import java.util.List;

public class StatisticsRepository {
    private List<DataEntry> dataEntryList = new ArrayList<>();

    public StatisticsRepository(){
    }

    public void addEntry(String expression, long time){
        dataEntryList.add(new DataEntry(expression,time));
    }

    public int getNoOfCalculations(){
        return dataEntryList.size();
    }

    public long getLowestComputeTime(){
        if(dataEntryList.size()==0)
            throw new IllegalArgumentException("Empty repository. Cannot provide the lowest compute time");
        long temp=dataEntryList.get(0).getTime();
        for (DataEntry dt:dataEntryList) {
            if(temp>dt.getTime())
                temp=dt.getTime();
        }
        return temp;
    }

    public long getHighestComputeTime(){
        if(dataEntryList.size()==0)
            throw new IllegalArgumentException("Empty repository. Cannot provide the lowest compute time");
        long temp=dataEntryList.get(0).getTime();
        for (DataEntry dt:dataEntryList) {
            if(temp<dt.getTime())
                temp=dt.getTime();
        }
        return temp;
    }

    public int getNoOfLowerComputeTimesThan(long time){
        if(time<=0)
            throw new IllegalArgumentException("Time should not be 0 or below. Cannot proceed with this operation");
        int count=0;
        for(DataEntry dt: dataEntryList){
            if(dt.getTime()<time)
                count++;
        }
        return count;
    }

    public int getNoOfHigherComputeTimesThan(long time){
        if(time<=0)
            throw new IllegalArgumentException("Time should not be 0 or below. Cannot proceed with this operation");
        int count=0;
        for(DataEntry dt: dataEntryList){
            if(dt.getTime()>time)
                count++;
        }
        return count;
    }

    public void removeExpressionTime(String expression){
        DataEntry temp=null;
        for(DataEntry dt:dataEntryList)
            if(dt.getExpression().equals(expression)){
                temp=dt;
                break;
            }
        if(temp!=null)
            dataEntryList.remove(temp);
        else
            throw new IllegalArgumentException("You do not have that expression in the Repository. Cannot do the operation");
    }

    public void removeExpressionTime(long time){
        DataEntry temp=null;
        for(DataEntry dt:dataEntryList)
            if(time==dt.getTime()){
                temp=dt;
                break;
            }
        if(temp!=null)
            dataEntryList.remove(temp);
        else
            throw new IllegalArgumentException("You do not have that expression in the Repository. Cannot do the operation");
    }


}
