package com.zarj.ahClickAgain;


import android.content.Context;

import com.zarj.ahClickAgain.items.ItemsManager;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Datar {
    static Yaml yaml = new Yaml();
    static HashMap<String,LinkedHashMap> items = new HashMap<String,LinkedHashMap>();
    static HashMap<String,LinkedHashMap> bonuses = new HashMap<String,LinkedHashMap>();
    static HashMap<String,LinkedHashMap> enemyes = new HashMap<String,LinkedHashMap>();
    static HashMap<String,LinkedHashMap> bosses = new HashMap<String,LinkedHashMap>();
    static HashMap<String,LinkedHashMap> effects = new HashMap<String,LinkedHashMap>();




    public static void load() throws IOException {
        Context context= com.zarj.ahClickAgain.ZApp.huy.getInstance().getApplicationContext();
        InputStream input = context.getResources().openRawResource(R.raw.items);
        items = (HashMap<String,LinkedHashMap>) yaml.load(input);
        input.close();
        InputStream bon = context.getResources().openRawResource(R.raw.bonuses);
        bonuses = (HashMap<String,LinkedHashMap>) yaml.load(bon);
        bon.close();
        InputStream e = context.getResources().openRawResource(R.raw.mobs);
        enemyes = (HashMap<String,LinkedHashMap>) yaml.load(e);
        e.close();
        InputStream b = context.getResources().openRawResource(R.raw.bosses);
        bosses = (HashMap<String,LinkedHashMap>) yaml.load(b);
        b.close();
        InputStream ef = context.getResources().openRawResource(R.raw.effects);
        effects = (HashMap<String,LinkedHashMap>) yaml.load(ef);
        ef.close();

    }

    public static void loadItems(){
        ItemsManager.load();
    }
    public static void createItems(InputStream input){
        HashMap<String,HashMap> yamlMap = (HashMap<String,HashMap>) yaml.load(input);

        for(Object o : yamlMap.entrySet()){
            System.out.println(o);
            Map.Entry<String,LinkedHashMap> entry = (Map.Entry<String, LinkedHashMap>) o;
            String id = entry.getKey();
            LinkedHashMap values = entry.getValue();


            if(values.containsKey("name")){
                values.get("name");
            }


        }
    }
    public static HashMap<String,LinkedHashMap> getItemsMap(){
        return items;
    }

    public static HashMap<String,LinkedHashMap> getMobsMap(){
        return enemyes;
    }
    public static HashMap<String,LinkedHashMap> getBossMap(){
        return bosses;
    }
    public static HashMap<String,LinkedHashMap> getEffectsMap(){
        return effects;
    }





}
