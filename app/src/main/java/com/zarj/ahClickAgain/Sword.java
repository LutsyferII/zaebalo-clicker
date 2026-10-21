package com.zarj.ahClickAgain;

import java.io.File;

public class Sword implements Weapon{
    private static final long serialVersionUID = 5L;
    String name = "sword";
    int damage = 1;

    String img_id;

    String id;

    public Sword(int dmg, String nm, String img, String id){
        damage = dmg;
        name = nm;
        img_id = img;
        this.id = id;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public boolean has() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getImgSource() {
        return img_id;
    }

    @Override
    public File getImgFile() {
        return null;
    }
}
