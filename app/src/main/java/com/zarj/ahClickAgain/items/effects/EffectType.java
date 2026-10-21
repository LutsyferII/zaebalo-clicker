package com.zarj.ahClickAgain.items.effects;

import com.zarj.ahClickAgain.Player;

public enum EffectType {
    COINS{
        public void add(int amount){
            Player.setCoinsBuff(Player.getCoinsBuff()+amount);

        }
        public void decr(int amount){
            Player.setCoinsBuff(Player.getCoinsBuff()-amount);
        }
    }
    ,DMG{
        public void add(int amount){
            Player.setPercDmgBuff(Player.getPercDmgBuff()+amount);
            Player.updateDamage();
        }
        public void decr(int amount){
            Player.setPercDmgBuff(Player.getPercDmgBuff()-amount);
            Player.updateDamage();
        }
    },DPS{
        public void add(int amount){
            Player.setPercDpsBuff(Player.getPercDpsBuff()+amount);
        }
        public void decr(int amount){
            Player.setPercDpsBuff(Player.getPercDpsBuff()-amount);
        }
    };

    public void add(int amount){

    }
    public void decr(int amount){

    }

}
