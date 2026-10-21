package com.zarj.ahClickAgain.Dungeon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dungeon implements Serializable {
    private static final long serialVersionUID = 11L;
    List<DungeonLevel> levels = new ArrayList<>();
    String name;
    String id;


    public Dungeon(String id, String name, Collection<DungeonLevel> levels){
        this.id = id;
        this.name = name;
        this.levels.clear();
        for(DungeonLevel dl : levels){
            dl.setDungeon(this);
            this.levels.add(dl);
        }
    }
    public boolean equalsId(String id){
        return this.id.equals(id);
    }
    public DungeonLevel getLevel(int id){
        for(DungeonLevel lvl : levels){
            if(lvl.id==id){
                return lvl;
            }
        }
        return null;
    }
    public DungeonLevel getLevelOrFirst(int id){
        for(DungeonLevel lvl : levels){
            if(lvl.id==id){
                return lvl;
            }
        }
        return levels.get(0);
    }
    public DungeonLevel getNextLevel(int id){
        for(int i = 0;i<levels.size();i++){
            if(levels.get(i).checkId(id)){
                if(levels.size()>i+1){
                    return levels.get(i+1);
                }
            }
        }
        return levels.get(0);
    }
    public DungeonLevel getFirstLevel(){
        return levels.get(0);
    }
    public String getName(){
        return name;
    }
    public List<DungeonLevel> getLevels(){
        return levels;
    }
    public  int levelIndexPlus(DungeonLevel level){
        for(int i = 0;i<levels.size();i++){
            if(levels.get(i).checkId(level.id)){
                return i+1;
            }
        }
        return 1;
    }
    public  int levelIndexPlus(int  id){
        for(int i = 0;i<levels.size();i++){
            if(levels.get(i).checkId(id)){
                return i+1;
            }
        }
        return 1;
    }
    public boolean isLastLevel(int id){
        return levels.get(levels.size()-1).checkId(id);
    }



    public int getDLevelIndex(int id){
        for(int i = 0;i<levels.size();i++){
            if(levels.get(i).checkId(id)){
                return i+1;
            }
        }
        return 0;
    }
    public String getId(){
        return id;
    }

}
