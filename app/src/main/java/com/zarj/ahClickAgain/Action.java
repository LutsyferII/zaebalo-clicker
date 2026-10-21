package com.zarj.ahClickAgain;

public class Action {
    String id = "some_id";

    public Action(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public boolean checkId(String id){
        return this.id.equals(id);
    }
    public void action(){

    }
}
