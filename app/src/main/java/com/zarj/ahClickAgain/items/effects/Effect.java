package com.zarj.ahClickAgain.items.effects;

import com.zarj.ahClickAgain.utils.MapWorker;

import java.util.LinkedHashMap;

public class Effect {
    String id;
    String img = "eff_default";
    String name = "effect";
    EffectType type;
    int amount = 1;
    String lore = "Описание";
    int limit = 1;

    public Effect(String id, LinkedHashMap link){
        MapWorker worker = new MapWorker(link);
        this.id = id;
        String n = worker.getString("name");
        if(n!=null){
            name = n;
        }
        Integer a = worker.getInteger("amount");
        if(a!=null){
            amount = a;
        }
        String l = worker.getString("lore");
        if(l!=null){
            lore = l;
        }
        String t = worker.getString("type");
        if(t!=null&&EffectType.valueOf(t)!=null){
            type = EffectType.valueOf(t);
        }else{
            type = EffectType.DMG;
        }
        Integer lm = worker.getInteger("limit");
        if(lm != null){
            limit = lm;
        }
        if(worker.has("img")){
            img = worker.getString("img");
        }

    }
    public boolean checkId(String id){
        return this.id.equals(id);
    }

    public String getId(){
        return id;
    }
    public String getImg(){
        return img;
    }
    public int getLimit(){
        return limit;
    }
}
