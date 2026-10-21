package com.zarj.ahClickAgain.Dungeon.enemys;

import com.zarj.ahClickAgain.items.ItemDroper;

import java.util.LinkedHashMap;
import java.util.List;

public class Boss extends EnemyMob {

    private static final long serialVersionUID = 3L;

    long timer = 30L;




    public Boss(String id, String img, String name, long mhp, int exp, long reward, List<ItemDroper> drops){
        super(id,img,name,mhp,exp,reward,1, drops);

    }
    public Boss(String id,String img,String name,long mhp,int exp, long reward,long timer, List<ItemDroper> drops){
        super(id,img,name,mhp,exp,reward,1,drops);
        this.timer = timer;

    }
    public Boss(String id, LinkedHashMap map){
        super(id,map);
        if(map.containsKey("time")){
            timer = (long) map.get("time");
        }


    }
    public Boss clone(){
        return new Boss(this.id,this.img_id,this.name,this.maxhp,this.exp,this.reward,this.timer, this.dropers);
    }
    public long getTimer(){
        return timer;
    }
}
