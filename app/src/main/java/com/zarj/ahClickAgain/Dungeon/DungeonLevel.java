package com.zarj.ahClickAgain.Dungeon;

import com.zarj.ahClickAgain.Dungeon.enemys.Boss;
import com.zarj.ahClickAgain.Dungeon.enemys.EnemyMob;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class DungeonLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    static Random rand = new Random();
    Dungeon dung;
    final int id;
    int exp = 0;
    int need_exp = 10;



    String back_id = "back_1_1";

    public List<String> mobs = new ArrayList<>();
    String boss;

    public DungeonLevel(int id,int exp, Collection<String> mobs,String boss, Dungeon dungeon){
        this.id = id;
        this.need_exp = exp;
        this.mobs.clear();
        this.mobs.addAll(mobs);
        this.boss = boss;
        this.dung = dungeon;
    }
    public DungeonLevel(int id,int exp, Collection<String> mobs,String boss, Dungeon dungeon,String back_id){
        this.id = id;
        this.need_exp = exp;
        this.mobs.clear();
        this.mobs.addAll(mobs);
        this.boss = boss;
        this.dung = dungeon;
        this.back_id = back_id;
    }
    public DungeonLevel clone(){
        return new DungeonLevel(id,need_exp,mobs,boss,dung,back_id);
    }

    public boolean setExp(int exp){
        if(need_exp<=exp){
            this.exp=need_exp;
            return true;
        }else{
            this.exp = exp;
            return false;
        }
    }
    public void setDungeon(Dungeon dungeon){
        this.dung = dungeon;
    }
    public Dungeon getDung(){
        return dung;
    }

    public void setBackgroundId(String id){
        this.back_id = id;
    }
    public String getBackgroundId(){
        return back_id;
    }
    public EnemyMob rollEnemy(){

        return DungeonManager.rollMob(mobs);

    }
    public boolean addExp(int exp){
        if(this.need_exp-this.exp<=exp){
            this.exp = this.need_exp;
            return true;
        }else{
            this.exp+=exp;
            return false;
        }
    }
    public DungeonLevel getNextLevel(){
        if(!dung.isLastLevel(this.id)){
            System.out.println("NOT LAST");
            return dung.getNextLevel(id);
        }else if(DungeonManager.hasNextDungeon(dung.id)){
            System.out.println("HAS NEXT");
            return DungeonManager.getNextDung(dung.id).getFirstLevel();
        }else{
            System.out.println("NOT HAS NEXT");
            return null;
        }


    }

    public int getId(){
        return id;
    }
    public String getFullId(){
        return dung.id+":"+id;
    }
    public int getExp(){
        return exp;
    }
    public int getNeed_exp(){
        return need_exp;
    }
    public Boss getBoss(){
        return DungeonManager.getBoss(this.boss).clone();
    }

    public boolean checkId(int id){
        return (this.id==id);
    }


}
