package com.zarj.ahClickAgain;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class PetManager {
    public static List<Pet> pets = new ArrayList<>();

    static SharedPreferences sp;

    public static void create(SharedPreferences sps){
        sp = sps;
        pets.clear();
        pets.add(new Pet("1","doll_3","Пет 1",1,100));
        pets.add(new Pet("2","doll_4","Пет 2",4,400));
        pets.add(new Pet("3","doll_5","Пет 3",10,1000));
        pets.add(new Pet("4","doll_6","Пет 4",21,2100));
        pets.add(new Pet("5","doll_7","Пет 5",40,4000));
        pets.add(new Pet("6","doll_8","Пет 6",90,9000));
        pets.add(new Pet("7","doll_9","Пет 7",210,21000));

    }

    public static boolean hasPet(String id){
        for(Pet pet : pets){
            if(pet.checkId(id)){
                return pet.has;
            }
        }
        return false;
    }
    public static void rebirth(){
        create(sp);
        savePref();

    }
    public static void savePref(){
        SharedPreferences.Editor editor = sp.edit();
        for(Pet pet : pets){

                editor.putBoolean("pet_"+pet.id+"_has",pet.has);
                editor.putInt("pet_"+pet.id+"_dps",pet.dps);
                editor.putInt("pet_"+pet.id+"_level",pet.level);
                editor.commit();

        }
    }
    public static void loadPref(){
        for(Pet pet : pets){
            if(sp.contains("pet_"+pet.id+"_has")){
                pet.has = sp.getBoolean("pet_"+pet.id+"_has",false);
                pet.dps = sp.getInt("pet_"+pet.id+"_dps",pet.dps);
                pet.level = sp.getInt("pet_"+pet.id+"_level",pet.level);
            }
        }
    }
    public static int getAllDPS(){
        int dps = 0;
        for(Pet pet : pets){
            if(pet.has){
                dps+=pet.dps;
            }
        }
        return dps;
    }


}
