package com.zarj.ahClickAgain;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class WeaponManager {
    static List<Weapon> slots = new ArrayList<Weapon>();
    public static void create(){
        if(slots.isEmpty()){
            slots.add(new Sword(1,"Первый меч","ai_sword_0","0"));
            slots.add(new Sword(2,"Второй меч","ai_sword_1","1"));
            slots.add(new Sword(5,"Третий меч","ai_sword_2","2"));
            slots.add(new Sword(11,"Четвертый меч","ai_sword_3","3"));
            slots.add(new Sword(25,"Пятый меч","ai_sword_4","4"));
            slots.add(new Sword(60,"шестой меч","ai_sword_5","5"));
            slots.add(new Sword(150,"Седьмой меч","ai_sword_6","6"));
            slots.add(new Sword(270,"Восьмой меч","ai_sword_7","7"));
            slots.add(new Sword(520,"Девятый меч","ai_sword_8","8"));
            slots.add(new Sword(1200,"Десятый меч","ai_sword_9","9"));
            slots.add(new Sword(2500,"Одиннадцатый меч","ai_sword_10","10"));
            slots.add(new Sword(7500,"Двенадцатый меч","ai_sword_11","11"));
            slots.add(new Sword(20000,"Тренадцатый меч","ai_sword_12","12"));
        }

    }
    public static Weapon getWeapon(String id){
        for(Weapon w : slots){
            if(w.getId().equals(id)){
                return w;
            }
        }
        return null;
    }
    public  static  Weapon getWeaponOrFirst(String id){
        for(Weapon w : slots){
            if(w.getId().equals(id)){
                return w;
            }
        }
        return slots.get(0);
    }
    public  static  Weapon getFirstWeapon(){
        return slots.get(0);
    }
    public static boolean hasWeapon(String id){
        for(Weapon w : slots){
            if(w.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public static void saveHased(SharedPreferences sp){

    }
    public static void loadHased(SharedPreferences sp){

    }


}
