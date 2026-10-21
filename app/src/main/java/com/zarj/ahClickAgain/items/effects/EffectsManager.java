package com.zarj.ahClickAgain.items.effects;

import com.zarj.ahClickAgain.Datar;
import com.zarj.ahClickAgain.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EffectsManager {
    public static List<Effect> effects = new ArrayList<>();

    public static List<LiveEffect> lives = new ArrayList<>();

    //ТУТ БУДЕТ СПИСОК ЛАЙВ ЭФФЕКТОВ И МЕТОДЫ ВЗАИМОДЕЙСТВИЯ С НИМИ

    public static void load(){
        effects.clear();
        HashMap<String, LinkedHashMap> eff = Datar.getEffectsMap();
        for(Map.Entry<String, LinkedHashMap> entry : eff.entrySet()){
            effects.add(new Effect(entry.getKey(),entry.getValue()));
        }
    }
    public static boolean hasEffect(String id){
        for(Effect effect : effects){
            if(effect.checkId(id)){
                return true;
            }
        }
        return false;
    }
    public static Effect getEffect(String id){
        for(Effect effect : effects){
            if(effect.checkId(id)){
                return effect;
            }
        }
        return null;
    }
    public static void run(LiveEffect live){
        if(!live.enable){
            System.out.println("ЗАПУСК ЭФФЕКТА: "+live.effect.name+"(+"+live.effect.amount+"% "+live.effect.type.name()+") на "+live.time/1000+" секунд");
            live.timer = new Timer();

            live.effect.type.add(live.effect.amount);
            live.task = new TimerTask(){
                @Override
                public void run() {
                    if(!live.enable){

                        live.enable=true;
                    }else{
                        live.tempTime+=1000L;
                        System.out.println("EFFECT "+live.effect.name+" RUNED "+(live.time-live.tempTime) );
                        if(live.tempTime>=live.time){
                            live.tempTime = 0L;
                            live.effect.type.decr(live.effect.amount);
                            this.cancel();
                            live.timer.cancel();
                            Player.removeEffect(live.effect.id);
                            live.enable = false;
                            if(lives.contains(live)){
                                lives.remove(live);
                            }
                        }
                    }
                }
            };

            live.timer.schedule(live.task,1000L,1000L);
            live.enable = true;
        }
    }
    public static boolean run(String id, int time){
        for(LiveEffect live : lives){
            if(live.effect.id.equals(id)){
                if(live.live>=live.effect.limit){
                    return false;
                }else{
                    live.live++;
                    live.time+=time*1000;
                    return true;
                }
            }
        }
        for(Effect effect : effects){
            if(effect.id.equals(id)){
                System.out.println("ЗАПУСК ЭФФЕКТА на "+time);
                LiveEffect live = new LiveEffect(effect, time);
                run(live);
                live.live++;
                lives.add(live);
                return true;
            }
        }
        return false;
    }

}
