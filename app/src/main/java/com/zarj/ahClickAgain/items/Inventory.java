package com.zarj.ahClickAgain.items;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {

    static List<ItemStack> items = new ArrayList<>();

    public static void load(SharedPreferences peref){
        items = new ArrayList<>();
        Set<String> ids = peref.getStringSet("inv", new HashSet<>());
        for(String id : ids){
            ItemStack item = new ItemStack(id, peref.getInt(id,0));
            System.out.println("LOAD: [INV] LOAD ITEM: "+id+" in amount: "+item.amount);
            if(item.amount!=0){
                items.add(item);
            }
        }
        /*
        Set<ItemCreator> creators = ItemsManager.getCreatorsFromIds(ids);
        for(ItemCreator creator: creators){
            items.add(new ItemStack(creator, peref.getInt(creator.id,0)));

        }
        */
    }
    public static void save(SharedPreferences.Editor editor){
        HashMap<String,Integer> map = getIdAm();
        editor.putStringSet("inv",map.keySet());
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("SAVE: [INV] SAVED ITEM: "+entry.getKey()+" in amount: "+entry.getValue());
            editor.putInt(entry.getKey(),entry.getValue());
        }
    }

    public static void consume(String id){
        for(ItemStack item : items){
            if(item.id.equals(id)){
                if(item.consum()==0){
                    items.remove(item);
                }
            }
        }
    }
    public static void giveItem(ItemStack item){
        for(ItemStack i : items){
            if(i.id.equals(item.id)){
                i.amount+=item.amount;
                return;
            }
        }
        items.add(item);
    }
    public static void removeItem(ItemStack item){
        for(ItemStack i : items){
            if(i.id.equals(item.id)){
                if(i.amount<=item.amount){
                    items.remove(i);

                }else{
                    i.amount-=item.amount;
                }
                return;
            }
        }
    }




    public static List<ItemStack> getItems(){
        return items;
    }












    private static Set<String> getIds(){
        Set<String> set = new HashSet<>();
        for(ItemStack item : items){
            set.add(item.id);
        }
        return set;
    }
    private static HashMap<String,Integer> getIdAm(){
        HashMap<String,Integer> map = new HashMap<>();
        for(ItemStack item : items){
            map.put(item.id,item.amount);
        }
        return map;
    }

}
