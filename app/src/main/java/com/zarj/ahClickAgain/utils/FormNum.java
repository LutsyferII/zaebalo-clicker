package com.zarj.ahClickAgain.utils;

public class FormNum<T extends Number> {

    T num;
    public FormNum(T tet){
        num = tet;
    }
    public String getForm(){
        if(num.intValue()<1000){
            return ""+num;
        }else if(num.intValue()<1000000){
            return ""+num.intValue()/1000+"."+num.intValue()%1000/100+"k";
        }else if(num.intValue()<1000000000){
            return ""+num.intValue()/1000000+"."+num.intValue()%1000000/100000+"m";

        }else if(num.longValue()<1000000000000L){
            return ""+num.longValue()/1000000000L+"."+num.longValue()%1000000000L/100000000L+"t";

        }else if(num.longValue()<1000000000000000L){
            return ""+num.longValue()/1000000000000L+"."+num.longValue()%1000000000000L/100000000000L+"q";
        }else if(num.longValue()<1000000000000000000L){
            return ""+num.longValue()/1000000000000000L+"."+num.longValue()%1000000000000000L/100000000000000L+"qt";

        }else{
            return ""+num;
        }
    }
    public int getInt(){
        return num.intValue();
    }
    public long getLong(){
        return num.longValue();
    }
    public double getDouble(){
        return num.doubleValue();
    }
}
