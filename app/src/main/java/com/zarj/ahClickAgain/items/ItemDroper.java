package com.zarj.ahClickAgain.items;

import com.zarj.ahClickAgain.utils.Errors;

import kotlin.random.Random;

public class ItemDroper {
    public static final Random rand = Random.Default;

    String item;
    Double chance = 100.0;
    int amount = 1;
    int max_amount = 2;

    public ItemDroper(String s){
        if(!s.matches("(.*)\\{(.*)")||!s.matches("(.*)\\}(.*)")) {
            Errors.error("Неверное определение предмета!");
            return;
        }
        String[] f_splited = s.split("\\{");
        if(!f_splited[0].equalsIgnoreCase("item")&&!f_splited[0].equalsIgnoreCase("mmoitem")) {
            Errors.error("Неверный тип предмета! ("+f_splited[0]+")");
            return;
        }
        String[] s_splited = f_splited[1].split("\\}");
        String stats = s_splited[0];

        if(!stats.matches("(?i)(.*)(;|^| +)id=(.*)")) {
            Errors.error("Не указано id предмета!");
            return;
        }
        this.item = doStat(stats, "id=");
        if(s_splited.length>1) {
            String[] other = s_splited[1].split(" +");
            if(other.length>2) {
                String colvo = other[1];
                if(isNumeric(colvo)) {
                    this.amount=Integer.parseInt(colvo);
                }else if(colvo.matches("(.*)-(.*)")){
                    String[] amounts = colvo.split("-");
                    this.amount=Integer.parseInt(amounts[0]);
                    this.max_amount=Integer.parseInt(amounts[1]);
                }else {
                    Errors.error("§4[huy] Ошибка загрузки предмета!!! Ошибка загрузки количества.");
                }

                String chance = other[2];
                this.chance=Double.parseDouble(chance);

            }else {
                this.amount=Integer.parseInt(other[1]);

            }


        }
        System.out.println("LOADED ITEM: "+this.item+" amount: "+this.amount+" max am: "+this.max_amount+" chance: "+this.chance+"%");
        //this.amount = Integer.parseInt(doStat(stats,"(?i)(a=|amount=)"));
    }
    public String doStat(String s, String regex_1) {
        if(s.split("(?i)(;|^| +)"+regex_1)[1].matches("(?i)(.*);(.*)")) {
            return s.split(regex_1)[1].split(";")[0];
        }else {
            return s.split(regex_1)[1];
        }
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    public boolean isDrop(){
        double bound = rand.nextDouble(100.0);
        Errors.info("BOUND: "+bound);
        return (chance>=bound);
    }
    public ItemStack getDrop(){

        ItemCreator creator = ItemsManager.getItemCreator(item);
        int am = rand.nextInt(amount,max_amount);
        Errors.info("give item "+item+" in amount: "+am);
        return new ItemStack(creator, am);
    }
    public String getid(){
        return item;
    }

}
