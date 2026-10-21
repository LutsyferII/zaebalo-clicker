package com.zarj.ahClickAgain;

import java.io.File;
import java.util.LinkedHashMap;

public class Bonus implements Item {

    private static final long serialVersionUID = 5L;
    String name = "sword";
    String lore = "Item. just + 1 damage and dps";
    long price = 100;
    BonusActionType type = BonusActionType.DAMAGE;
    boolean sale = true;
    boolean has = false;
    boolean used = false;
    String img_id;
    String id;
    String info = "Описание";

    Action action;

    public Bonus(String id, String img_id, String name,String lore,long price,BonusActionType type ){
        this.id = id;
        this.img_id = img_id;
        this.name = name;
        this.lore = lore;
        this.price = price;
        this.type = type;
    }
    public Bonus(String id, String img_id, String name,String lore,long price,BonusActionType type,boolean sale){
        this.id = id;
        this.img_id = img_id;
        this.name = name;
        this.lore = lore;
        this.price = price;
        this.type = type;
        this.sale = sale;
    }
    public Bonus(String id, String img_id, String name,String lore,long price,BonusActionType type,boolean sale,String info){
        this.id = id;
        this.img_id = img_id;
        this.name = name;
        this.lore = lore;
        this.price = price;
        this.type = type;
        this.sale = sale;
        this.info = info;
    }

    public Bonus(String id,LinkedHashMap link){
        this.id = id;
        if(link.containsKey("name")){
            System.out.println("ИМЯ НАЙДЕНО! "+ link.get("name"));
            name =(String) link.get("name");
        }
        if(link.containsKey("img")){
            img_id = (String) link.get("img");
        }
        if(link.containsKey("lore")){
            lore= (String) link.get("lore");
        }
        if(link.containsKey("type")){
            if(BonusActionType.valueOf((String) link.get("type"))!=null){
                type = BonusActionType.valueOf((String) link.get("type"));
            }
        }
        if(link.containsKey("info")){
            info = (String) link.get("info");
        }

        if(link.containsKey("action")){
            String action_id = (String) link.get("action");
            Action act = BonusManager.getAction(action_id);
            if(act!=null){
                this.action = act;
            }
        }
        if(link.containsKey("price")){
            price = (int) link.get("price");
        }
        if(link.containsKey("sale")){
            sale = (boolean) link.get("sale");
        }




    }


    public void setAction(Action ac){
        this.action = ac;
    }
    public void someAction(){
        used = true;
        action.action();
    }
    public boolean checkAction(BonusActionType bat){
        return this.type.equals(bat);
    }
    public String getLore(){
        return lore;
    }
    @Override
    public String getImgSource() {
        return img_id;
    }

    @Override
    public File getImgFile() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
