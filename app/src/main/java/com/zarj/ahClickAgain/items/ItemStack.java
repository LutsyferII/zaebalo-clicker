package com.zarj.ahClickAgain.items;

import com.zarj.ahClickAgain.items.effects.EffectsManager;

import java.util.LinkedHashMap;

public class ItemStack extends ItemCreator{

    int amount = 1;
    public ItemStack(ItemCreator creator, int am){
        super();
        super.loadFromCopy(creator);
        amount = am;
    }
    public ItemStack(String id, int am){
        super();
        ItemCreator creator = ItemsManager.getItemCreator(id);
        if(creator!=null){
            super.loadFromCopy(creator);
            amount = am;
        }else{
            amount = 0;
        }
    }
    public ItemStack(String id, LinkedHashMap link) {
        super(id, link);
    }
    public int consum(){
        if(consumable){
            if(this.effect!=null){
                if(EffectsManager.run(effect,effect_time)){
                    amount--;
                }
            }
        }
        return amount;
    }
    public int consum(int am){
        if(consumable) {
            amount = -am;
        }
        return amount;
    }
    public int add(int am){
        amount=+am;
        return amount;
    }
    public String getImg(){
        return img;
    }
    public boolean isConsumable(){
        return consumable;
    }
    public int getAmount(){
        return amount;
    }



}
