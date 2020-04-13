package ro.siit;

import java.util.Scanner;

public class Calculator {

    //mm, cm, dm, m, km

    public void start(){
        Scanner s= new Scanner(System.in);
        String r1 ="";
        String r2="";
        while(true){
            System.out.println("Va rugam alegeti dintre optiunile de mai jos: \n1 - Calculeaza \n2 - Iesi \nAlege 1 sau 2");
            if(s.hasNext())
                r1=s.nextLine();
            if(r1.equals("1"))
            {
                System.out.println("Va rugam sa introduceti expresia:");
                if(s.hasNextLine())
                    r1=s.nextLine();

                System.out.println("Va rugam introduceti unitatea de masura in care vreti sa fie afisat rezultatul:");
                if(s.hasNextLine())
                    r2=s.nextLine();
                calculate(r1,r2);
            }
            if(r1.equals("2"))
                break;
        }
    }


    public float calculate(String s,String output) throws IllegalArgumentException{
        float result=0;
        int i=2;
        String[] parts = s.split(" ");
        try{
            this.validate(parts);
            result+=convertToMm(Float.parseFloat(parts[0]),parts[1]);
        while(i<parts.length){
            if(parts[i].equals("+"))
                result=addition(result,Float.parseFloat(parts[i+1]),parts[i+2]);
            else
                result=substract(result,Float.parseFloat(parts[i+1]),parts[i+2]);
            i+=3;
        }
        try {
            return convertForOutput(result,output);
        }
        catch(Exception e){
            throw e;
        }



        }
        catch(Exception e){
            throw e;
        }

    }

    public float addition(float x, float y, String m){
        return x+ convertToMm(y,m);
    }

    public float substract(float x, float y, String m){
        return x - convertToMm(y,m);
    }

    public float convertForOutput(float r,String s) throws IllegalArgumentException{
        if(s.equals("km"))
            return r/1000000;
        if(s.equals("m"))
            return r/1000;
        if(s.equals("dm"))
            return r/100;
        if(s.equals("cm"))
            return r/10;
        if(s.equals("mm"))
            return r;
        throw new IllegalArgumentException("Incorrect metrical information, format invalid. Try again!");
    }
    public float convertToMm(float x, String s) throws IllegalArgumentException{
        if(s.equals("mm"))
            return x;
        if(s.equals("cm"))
            return x*10;
        if(s.equals("dm"))
            return x*100;
        if(s.equals("m"))
            return x*1000;
        if(s.equals("km"))
            return x*1000000;

        throw new IllegalArgumentException("Incorrect metrical information, format invalid. Try again!");
    }

    public void validate(String[] parts) throws IllegalArgumentException{
        if(parts.length<2)
            throw new IllegalArgumentException("Too less attributes. Cannot compute. Please make sure you follow the pattern.");
        int poz=0;
        String s;

        try {
           if(Float.parseFloat(parts[poz]) <0)
               throw new IllegalArgumentException("1Bad Input. Cannot compute. Please make sure you follow the pattern.");
        }
        catch (Exception e){
            throw new IllegalArgumentException("Error: Number was expected. Cannot compute. Please make sure you follow the pattern.");
        }
        poz++;
        s=parts[poz];
        if(!(s.equals("mm") || s.equals("cm") || s.equals("dm") || s.equals("km") ||s.equals("m")))
            throw new IllegalArgumentException("Error: metrical information expected. Cannot compute. Please make sure you follow the pattern.");
        poz++;

        while(poz<parts.length){

            if((parts.length-poz) <3)
                throw new IllegalArgumentException("Error: Too few arguments. Cannot compute. Please make sure you follow the pattern.");

            if(!(parts[poz].equals("+") || parts[poz].equals("-")))
                throw new IllegalArgumentException("Error: Bad opperand. Cannot compute. Please make sure you follow the pattern.");

            poz++;
            try {
                Float.parseFloat(parts[poz]);
            }
            catch (Exception e){
                throw new IllegalArgumentException("Error: Number was expected. Cannot compute. Please make sure you follow the pattern.");
            }

            poz++;
            s=parts[poz];
            if(!(s.equals("mm") || s.equals("cm") || s.equals("dm") || s.equals("km") ||s.equals("m")))
                throw new IllegalArgumentException("Error: metrical information expected. Cannot compute. Please make sure you follow the pattern.");

            poz++;

        }
    }
}
