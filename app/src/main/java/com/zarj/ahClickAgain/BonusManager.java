package com.zarj.ahClickAgain;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BonusManager {

    static List<Bonus> bonuses = new ArrayList<>();
    static List<Action> actions = new ArrayList<>();


    static SharedPreferences sp;
    public static void create(SharedPreferences spr){
        bonuses.clear();
        createActions();
        for(Map.Entry<String, LinkedHashMap> entry : Datar.bonuses.entrySet()){
            bonuses.add(new Bonus(entry.getKey(),entry.getValue()));
        }
        /*
        Bonus first = new Bonus("1","bonus_1","Руна урона","Руна, увеличивающая урон нажатием на 10%",500,BonusActionType.PERC_DAMAGE){
            @Override
            public void someAction(){
                Player.perc_damage_buff+=10;
            }
        };
        bonuses.add(first);
        Bonus two= new Bonus("2","bonus_2","Руна помощи","Руна, увеличивающая урон союзников на 10%",2000,BonusActionType.PERC_DPS){
            @Override
            public void someAction(){
                Player.perc_dps_buff+=10;
            }
        };
        bonuses.add(two);
        Bonus p= new Bonus("3","gold_drop","Золотая капля","Увеличивает получаемое золото на 10%",5000,BonusActionType.COINS){
            @Override
            public void someAction(){
                Player.coins_buff+=10;
            }
        };
        bonuses.add(p);
        Bonus tr= new Bonus("4","bonus_3","Пески времени","Руна, увеличивающая урон ударом на 100",10000,BonusActionType.DAMAGE){
            @Override
            public void someAction(){
                Player.damage_buff+=100;
            }
        };
        bonuses.add(tr);
        Bonus f= new Bonus("5","bonus_3","test","увеличивающая урон ударом на 10",5000,BonusActionType.DAMAGE,false,"Чтобы получить, переродитесь хотябы раз!"){
            @Override
            public void someAction(){
                Player.damage_buff+=10;
            }
        };
        bonuses.add(f);
        bonuses.add(new Bonus("6","bonus_3","test","увеличивающая урон ударом на 500",200000,BonusActionType.DAMAGE,false,"Чтобы получить, переродитесь хотябы раз!"){
            @Override
            public void someAction(){
                Player.damage_buff+=500;
            }
        });


        Bonus gold_2= new Bonus("gold_2","midas","Рука Мидаса","Увеличивает получаемое золото на 100%",50000,BonusActionType.COINS){
            @Override
            public void someAction(){
                Player.coins_buff+=100;
            }
        };
        bonuses.add(gold_2);

        Bonus dps_1= new Bonus("dps_1","angel_1","Кукла ангела","Призывает помощника ангела наносящего 1000 урона в секунду.",100000,BonusActionType.DPS){
            @Override
            public void someAction(){
                Player.dps_buff+=1000;
            }
        };
        bonuses.add(dps_1);

        Bonus dps_perc_1= new Bonus("dps_perc_1","horn","Горн усиления","+100% к урону помощников.",500000,BonusActionType.PERC_DPS){
            @Override
            public void someAction(){
                Player.perc_dps_buff+=100;
            }
        };
        bonuses.add(dps_perc_1);



        Bonus dmg_perc_2= new Bonus("dmg_perc_2","runic_sharp","Рунный точильный камень","+100% к урону оружием.",750000,BonusActionType.PERC_DAMAGE){
            @Override
            public void someAction(){
                Player.perc_damage_buff += 100;
            }
        };
        bonuses.add(dmg_perc_2);
        */



        sp = spr;
    }



    public static void savePeref(){
        SharedPreferences.Editor editor = sp.edit();

        for(Bonus bonus :bonuses){
            editor.putBoolean("Bonus_has_"+bonus.id,bonus.has);
        }
        editor.commit();

    }
    public static void loadPered(){
        for(Bonus bonus : bonuses){
            if(sp.contains("Bonus_has_"+bonus.id)){
                bonus.has = sp.getBoolean("Bonus_has_"+bonus.id,false);
            }
        }
    }

    public static void dropUse(){
        for(Bonus bonus : bonuses){
            if(bonus.used){
                bonus.used = false;
            }
        }
    }
    public static void letsActions(){
        for(Bonus bonus : bonuses){
            if(bonus.has&&!bonus.used){
                bonus.someAction();
                bonus.used = true;
            }
        }
    }
    public static void letsCoolActions(){

        List<Bonus> dmg = new ArrayList<>();
        List<Bonus> dps = new ArrayList<>();
        List<Bonus> perc_dmg = new ArrayList<>();
        List<Bonus> perc_dps = new ArrayList<>();
        for(Bonus bonus : bonuses){
            if(bonus.has){
               switch(bonus.type){
                   case DAMAGE:
                       dmg.add(bonus);
                       break;
                   case DPS:
                       dps.add(bonus);
                       break;
                   case PERC_DAMAGE:
                       perc_dmg.add(bonus);
                       break;
                   case PERC_DPS:
                       perc_dps.add(bonus);
                       break;

               }
            }
        }
        doActions(dmg);
        doActions(dps);
        doActions(perc_dmg);
        doActions(perc_dps);
    }
    private static void doActions(List<Bonus> bonuses){
        for(Bonus bonus : bonuses){
            bonus.someAction();

        }
    }
    public static List<Bonus> getSalable(){
        List<Bonus> salable = new ArrayList<>();
        for(Bonus bonus : bonuses){
            if(bonus.sale){
                salable.add(bonus);
            }
        }
        return salable;
    }
    public static List<Bonus> getNotSalable(){
        List<Bonus> salable = new ArrayList<>();
        for(Bonus bonus : bonuses){
            if(!bonus.sale){
                salable.add(bonus);
            }
        }
        return salable;
    }
    public static Bonus getById(String id){
        for(Bonus bonus : bonuses){
            if(bonus.id.equals(id)){
                return bonus;
            }
        }
        return null;
    }

    public static boolean hasAction(String id){
        for(Action action : actions){
            if(action.checkId(id)){
                return true;
            }
        }
        return false;
    }
    public static Action getAction(String id){
        for(Action action : actions){
            if(action.checkId(id)){
                return action;
            }
        }
        return null;
    }
    public static void createActions(){
        actions.clear();

        actions.add(new Action("1"){
            @Override
            public void action(){Player.perc_damage_buff+=10;}
        });
        actions.add(new Action("2"){
            @Override
            public void action(){Player.perc_dps_buff+=10;}
        });
        actions.add(new Action("3"){
            @Override
            public void action(){Player.coins_buff+=10;}
        });
        actions.add(new Action("4"){
            @Override
            public void action(){Player.damage_buff+=100;}
        });
        actions.add(new Action("5"){
            @Override
            public void action(){Player.damage_buff+=10;}
        });
        actions.add(new Action("6"){
            @Override
            public void action(){Player.damage_buff+=500;}
        });
        actions.add(new Action("gold_2"){
            @Override
            public void action(){Player.coins_buff+=100;}
        });
        actions.add(new Action("dps_1"){
            @Override
            public void action(){Player.dps_buff+=1000;}
        });
        actions.add(new Action("dps_perc_1"){
            @Override
            public void action(){Player.perc_dps_buff+=100;}
        });
        actions.add(new Action("dmg_perc_2"){
            @Override
            public void action(){Player.perc_damage_buff += 100;}
        });
    }

}

