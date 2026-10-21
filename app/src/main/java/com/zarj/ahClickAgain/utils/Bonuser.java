package com.zarj.ahClickAgain.utils;

import com.zarj.ahClickAgain.Bonus;

import java.util.List;

public class Bonuser {
    Bonus first ;
    Bonus second;
    Bonus three;

    public Bonuser(){

    }
    public void addBonus(Bonus bonus){
        if(first==null){
            first = bonus;
        }else if(second == null){
            second = bonus;
        }else{
            three = bonus;
        }
    }

    public static List<Bonuser> toBonuser(List<Bonus> bonuses){
return null;
    }

}
