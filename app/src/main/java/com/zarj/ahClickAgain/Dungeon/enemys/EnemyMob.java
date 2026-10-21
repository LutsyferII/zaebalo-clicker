package com.zarj.ahClickAgain.Dungeon.enemys;

import com.zarj.ahClickAgain.Imagable;
import com.zarj.ahClickAgain.items.Inventory;
import com.zarj.ahClickAgain.items.ItemDroper;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class EnemyMob implements Enemy, Imagable, Serializable {
    private static final long serialVersionUID = 5L;
    long hp = 1;
    final long maxhp;
    final String name;
    final String img_id;
    final String id;
    final int exp;
    final long reward;

    final int weight;

    List<ItemDroper> dropers = new ArrayList<>();

    public EnemyMob(String id,String img,String name,long mhp,int exp, long reward, int weight, List<ItemDroper> d){
        this.id = id;
        this.img_id = img;
        this.name = name;
        this.maxhp = mhp;
        this.hp = mhp;
        this.exp = exp;
        this.reward = reward;
        this.weight = weight;
        dropers.addAll(d);

    }
    public EnemyMob(String id, LinkedHashMap link){
        this.id = id;
        if(link.containsKey("name")){
            name = (String) link.get("name");
        }else{
            name = "chelic";
        }
        if(link.containsKey("img")){
            img_id= (String) link.get("img");
        }else{
            img_id = "ai_doll_0";
        }
        if(link.containsKey("hp")){
            maxhp = (long) link.get("hp");
        }else{
            maxhp = 10;
        }
        if(link.containsKey("exp")){
            exp = (int) link.get("exp");
        }else{
            exp = 10;
        }
        if(link.containsKey("reward")){
            reward = (long) link.get("reward");
        }else{
            reward = 10;
        }
        if(link.containsKey("weight")){
            weight = (int) link.get("weight");
        }else{
            weight= 10;
        }
        if(link.containsKey("drop")){
            List<String> drops = (List<String>)link.get("drop");
            System.out.println("DROPS LOAD : "+drops.size());
            for(String s : drops){
                dropers.add(new ItemDroper(s));
            }
        }

    }


    @Override
    public long getHP() {
        return hp;
    }

    @Override
    public long getMaxHP() {
        return maxhp;
    }

    @Override
    public long damage(long h) {
        if(h>=hp){
            hp = 0;
        }else{
            this.hp-=h;
        }
        return this.hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Enemy kill() {
        return this;
    }

    @Override
    public EnemyMob clone() {
        EnemyMob mob = new EnemyMob(this.id,this.img_id,this.name,this.maxhp,this.exp,this.reward, this.weight, this.dropers);
        return mob;
    }

    @Override
    public long heal(long h) {
        if(hp+h>maxhp){
            hp=maxhp;
        }
        this.hp+=h;
        return hp;
    }

    @Override
    public void doDrop(){
        if(dropers.isEmpty()){
            return;
        }
        for(ItemDroper drop : dropers){
            if(drop.isDrop()){
                System.out.println("GIVE ITEM "+drop.getid());
                Inventory.giveItem(drop.getDrop());
            }
        }
    }

    @Override
    public int getExp() {
        return this.exp;
    }

    @Override
    public long getCoins() {
        return this.reward;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean equalsId(String id) {
        return this.id.equals(id);
    }

    @Override
    public String getImgSource() {
        return img_id;
    }

    @Override
    public File getImgFile() {
        return null;
    }

    public int getWeight(){
        return weight;
    }
}
