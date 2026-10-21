package com.zarj.ahClickAgain.items;

import java.util.LinkedHashMap;

public class ItemCreator{

    String id;
    String name = "Предмет";
    int limit = 1;

    String lore = " Описание";
    ItemType type = ItemType.DEFAULT;
    String img;

    String effect;
    int effect_time = 1;

    Rarity rarity;

    boolean consumable = false;

    ItemCreator(){

    }
    public ItemCreator(String id, String name, String img, int limit, Rarity rarity){
        this.id = id;
        this.name = name;
        this.img = img;
        this.limit = limit;
        this.rarity = rarity;
    }
    public ItemCreator(String id,LinkedHashMap link){
        this.id = id;
        if(link.containsKey("name")){
            System.out.println("ИМЯ НАЙДЕНО! "+ link.get("name"));
            name =(String) link.get("name");
        }
        if(link.containsKey("img")){
            img = (String) link.get("img");
        }
        if(link.containsKey("limit")){
            limit = (int) link.get("limit");
        }
        if(link.containsKey("rarity")){
            rarity = Rarity.valueOf((String)link.get("rarity"));
        }
        if(link.containsKey("type")){
            String tp = (String)link.get("type");
            ItemType temp_type = ItemType.checkAndReturn(tp);
            if(temp_type!=null){
                this.type = temp_type;
            }
        }
        if(link.containsKey("lore")){
            lore = (String) link.get("lore");
        }

        if(link.containsKey("effect")){
            effect = (String)link.get("effect");
            consumable = true;

        }
        if(link.containsKey("eff_time")){
            effect_time = (int) link.get("eff_time");
            System.out.println("EFFECT_TIME = "+effect_time);
        }

        System.out.println("Завершено создание предмета: "+id);
        System.out.println("   Имя: "+name);
        System.out.println("   img: "+img);
        System.out.println("   limit: "+limit);
        System.out.println("   Rarity: "+rarity);

    }

    public void loadFromCopy(ItemCreator creator){
        this.id = creator.id;
        this.consumable = creator.consumable;
        this.limit = creator.limit;
        this.img = creator.img;
        this.name = creator.name;
        this.effect = creator.effect;
        this.type = creator.type;
        this.rarity = creator.rarity;
        this.lore = creator.lore;
        this.effect_time = creator.effect_time;
    }



    public void TapAction(){

    }

    public boolean checkId(String id){
        return this.id.equals(id);
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public Rarity getRarity(){
        return rarity;
    }
    public boolean equalRarity(Rarity rar){
        return rarity.equals(rar);
    }

}
