package com.zarj.ahClickAgain.utils;

public class RollSlot<V> {
    V lot;
    int weight;
    Double from =0.0;
    Double  to = 100.0;
    public RollSlot(V v, int w){
        lot = v;
        weight = w;
    }
    public V getLot(){
        return lot;
    }
    public int getWeight(){
        return weight;
    }
    public void setTo(Double d){
        to = d;
    }
    public Double getTo(){
        return to;
    }
    public boolean inBound(Double b){
        return (to>=b);
    }

}
