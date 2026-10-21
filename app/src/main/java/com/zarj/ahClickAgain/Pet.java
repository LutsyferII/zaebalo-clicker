package com.zarj.ahClickAgain;

public class Pet {

    int dps = 0;
    String name = "pet";
    String img_id;

    boolean has = false;
    int price = 0;

    int level = 1;

    int max_level = 25;

    String id;

    public Pet(String id, String img_id, String name, int dps,int price,int max_level){
        this.id = id;
        this.img_id = img_id;
        this.name = name;
        this.dps = dps;
        this.max_level = max_level;
        this.price = price;

    }
    public Pet(String id, String img_id, String name, int dps,int price){
        this.id = id;
        this.img_id = img_id;
        this.name = name;
        this.dps = dps;
        this.price = price;

    }
    public boolean checkId(String id){
        return this.id.equals(id);
    }

    public boolean has(){
        return has;
    }

    public boolean canLevelUp(){
        return level<max_level;
    }
    public int levelUp(){
        level++;
        dps+=getDamageFromUpgare();
        return dps;
    }


    public int getDamageFromUpgare(){
        return dps;
    }
    public int getUpgradePrice(int price){
        return price*(level/2);
    }
    public int getUpgradePrice(){

        double prtic = price * Math.pow(2.5,(double) level);
        return (int) prtic ;//((double)price*((double)level*2.5));
    }
    public int getDps(){
        return dps;
    }
    public String getId(){
        return id;
    }
    public String getImgId(){
        return img_id;
    }
    public String getName(){
        return name;
    }

}
