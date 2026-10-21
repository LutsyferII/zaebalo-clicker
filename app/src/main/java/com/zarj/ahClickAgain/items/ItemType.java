package com.zarj.ahClickAgain.items;

public enum ItemType {
    DEFAULT;
    public static boolean check(String str){
        for(ItemType type :ItemType.values()){
            if(type.name().equals(str)){
                return true;
            }
        }
        return false;
    }
    public static ItemType checkAndReturn(String str){
        for(ItemType type :ItemType.values()){
            if(type.name().equalsIgnoreCase(str)){
                return type;
            }
        }
        return null;
    }

}
