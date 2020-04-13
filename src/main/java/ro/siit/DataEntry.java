package ro.siit;

public class DataEntry {
    private String expression;
    private long time;

    public DataEntry(String expression, long time) {
        this.expression = expression;
        this.time = time;
    }

    public String getExpression() {
        return expression;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString(){
        return "Elapse time is: " + this.time +" for the experiosn:  " +this.expression;
    }
}
