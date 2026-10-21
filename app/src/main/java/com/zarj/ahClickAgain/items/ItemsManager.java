package com.zarj.ahClickAgain.items;



import com.zarj.ahClickAgain.Datar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ItemsManager {

    static List<ItemCreator> itemser = new ArrayList<>();

    public static void load(){
        itemser.clear();
        ItemCreator noll = new ItemCreator("noll","ОШИБКА","error",1,Rarity.COMMON);
        itemser.add(noll);
        HashMap<String, LinkedHashMap> map = Datar.getItemsMap();
        for(Map.Entry<String,LinkedHashMap> entry : map.entrySet()){
            String id = entry.getKey();
            itemser.add(new ItemCreator(id,entry.getValue()));
        }
    }
    public static ItemCreator getItemCreator(String id){
        for(ItemCreator item : itemser){
            if(item.checkId(id)){
                return item;
            }
        }
        return itemser.get(0);
    }
    public static boolean hasItemCreator(String id){
        for(ItemCreator item : itemser){
            if(item.checkId(id)){
                return true;
            }
        }
        return false;
    }
    public static Set<ItemCreator> getCreatorsFromIds(Set<String> ids){
        Set<ItemCreator> creators = new HashSet<>();
        List<ItemCreator> items = new ArrayList<>();
        items.addAll(itemser);
        for(String id : ids){
            for(ItemCreator item : items){
                if(item.id.equals(id)){
                    creators.add(item);
                    items.remove(item);
                    break;
                }
            }
        }
        return creators;
    }
    public static List<ItemCreator> getAll(){
        return itemser;
    }

}
