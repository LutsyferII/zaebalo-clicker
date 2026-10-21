package com.zarj.ahClickAgain;

import java.io.Serializable;

public interface Weapon extends Serializable, Item {
    static final long serialVersionUID = 1L;
    public int getDamage();

    public boolean has();

}
