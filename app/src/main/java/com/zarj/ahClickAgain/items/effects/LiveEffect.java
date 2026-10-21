package com.zarj.ahClickAgain.items.effects;

import com.zarj.ahClickAgain.Player;

import java.util.Timer;
import java.util.TimerTask;

public class LiveEffect {
    Effect effect;
    Long time = 1000L;
    Long tempTime = 0L;

    public int live = 0;
    TimerTask task;
    Timer timer = new Timer();
    boolean enable = false;
    public LiveEffect(String effect_id,int sec){
        Effect ef = EffectsManager.getEffect(effect_id);
        if(ef!=null){
            effect = ef;
        }else{
            System.out.println("False in create live effect \""+effect_id+"\" : no effects with this id.");
            return;
        }
        time = sec*1000L;

    }
    public LiveEffect(Effect ef, int sec){
        effect = ef;
        time = sec*1000L;
    }
    public void stop(){
        effect.type.decr(effect.amount);

        timer.cancel();

        Player.removeEffect(effect.id);
        tempTime = 0L;
        enable = false;
    }
    public void run(){
        if(!enable){
            System.out.println("ЗАПУСК ЭФФЕКТА: "+effect.name+"(+"+effect.amount+"% "+effect.type.name()+") на "+time/1000+" секунд");
            timer = new Timer();

            effect.type.add(effect.amount);
            task = new TimerTask(){
                @Override
                public void run() {
                    if(!enable){

                        enable=true;
                    }else{
                        tempTime+=1000L;
                        System.out.println("EFFECT "+effect.name+" RUNED "+(time-tempTime) );
                        if(tempTime>=time){
                            tempTime = 0L;
                            effect.type.decr(effect.amount);
                            this.cancel();
                            timer.cancel();
                            Player.removeEffect(effect.id);
                            enable = false;
                        }
                    }
                }
            };

            timer.schedule(task,1000L,1000L);
            this.enable = true;
        }
    }
    public void addTime(int t){
        this.time+=t*1000L;
    }
    public String getId(){
        return effect.id;
    }
    public int timeSec(){
        if(tempTime!=0){
            return Math.toIntExact(time-tempTime/1000);
        }else{
            return 0;
        }
    }
    public Long getTime(){
        return time;
    }

    public boolean isRunned(){
        return enable;
    }


    public Effect getEffect(){
        return effect;
    }
    public String getTimeSec(){
        int sec = (int) ((time - tempTime)/1000);
        if(sec>60){
            return sec/60+":"+sec%60;
        }else{
            return sec+"";
        }
    }
    public int getLive(){
        return live;
    }
}
