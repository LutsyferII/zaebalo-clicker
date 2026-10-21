package com.zarj.ahClickAgain.items;

public enum Rarity {
    COMMON("fon_grey"),UNCOMMON("fon_yellow"),RARE("fon_green"),VARYRARE("fon_blue"),LEGENDARY("fon_orange"),MYTHICAL("fon_purp");

    String color;


    Rarity(String c){
        color = c;
    }
    public String getColorImg(){
        return color;
    }

}
