package com.zarj.ahClickAgain.market;

import com.zarj.ahClickAgain.WeaponManager;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static List<MarketSlot> slots = new ArrayList<MarketSlot>();

    public static void create(){
        if(slots.isEmpty()){
            slots.add(new MarketSlot(1,10, WeaponManager.getWeapon("1")));
            slots.add(new MarketSlot(2,100, WeaponManager.getWeapon("2")));
            slots.add(new MarketSlot(3,500, WeaponManager.getWeapon("3")));
            slots.add(new MarketSlot(4,5000, WeaponManager.getWeapon("4")));
            slots.add(new MarketSlot(5,25000, WeaponManager.getWeapon("5")));
            slots.add(new MarketSlot(6,75000, WeaponManager.getWeapon("6")));
            slots.add(new MarketSlot(7,200000, WeaponManager.getWeapon("7")));
            slots.add(new MarketSlot(8,500000, WeaponManager.getWeapon("8")));
            slots.add(new MarketSlot(9,1500000, WeaponManager.getWeapon("9")));
            slots.add(new MarketSlot(10,2500000, WeaponManager.getWeapon("10")));
            slots.add(new MarketSlot(11,7250000, WeaponManager.getWeapon("11")));

        }

    }
    public static MarketSlot getSlot(int id){
        for(MarketSlot slot : slots){
            if(slot.isEquals(id)){
                return slot;
            }
        }
        return null;
    }
    public static List<MarketSlot> getSlots(){
        return slots;
    }



}
