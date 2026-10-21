package com.zarj.ahClickAgain.utils;

import java.util.LinkedHashMap;
import java.util.List;

public class MapWorker {
    LinkedHashMap link;

    public MapWorker(LinkedHashMap map){
        this.link = map;
    }
    public boolean has(String id){
        return link.containsKey(id);
    }
    public boolean isInteger(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Integer)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isString(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof String)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isBoolean(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Boolean)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isLong(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Long)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isDouble(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Double)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isList(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof List)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isStringList(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof List)&&(((List<?>) link.get(id)).get(0) instanceof  String)){
            return true;
        }else{
            return false;
        }
    }


    public Integer getInteger(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Integer)){
            return (Integer)link.get(id);
        }else{
            return null;
        }
    }
    public String getString(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof String)){
            return (String) link.get(id);
        }else{
            return null;
        }
    }
    public Boolean getBoolean(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Boolean)){
            return (Boolean)link.get(id);
        }else{
            return null;
        }
    }
    public Long getLong(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Long)){
            return (Long)link.get(id);
        }else{
            return null;
        }
    }
    public Double getDouble(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof Double)){
            return (Double)link.get(id);
        }else{
            return null;
        }
    }
    public List getList(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof List)){
            return (List) link.get(id);
        }else{
            return null;
        }
    }
    public List<String> getStringList(String id){
        if(link.containsKey(id)&&(link.get(id) instanceof List)&&(((List) link.get(id)).get(0) instanceof  String)){
            return (List<String>) link.get(id) ;
        }else{
            return null;
        }
    }

}
