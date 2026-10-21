package com.zarj.ahClickAgain.market;

import com.zarj.ahClickAgain.Item;

public class MarketSlot {
    Item weapon;

    int id = 0;

    long price = 1;

    public MarketSlot(int id, long price, Item weap){
        this.id = id;
        this.price = price;
        this.weapon = weap;
    }
    public boolean isEquals(int id){
        return this.id==id;

    }
    public Item getWeapon(){
        return weapon;
    }

    public String getWeaponImg(){
        return weapon.getImgSource();
    }
    public long getPrice(){
        return price;
    }



}
