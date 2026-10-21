package com.zarj.ahClickAgain.Dungeon.enemys;

import com.zarj.ahClickAgain.Imagable;

public interface Enemy extends Imagable {
    static final long serialVersionUID = 10L;
    public long getHP();
    public long getMaxHP();
    public long damage(long h);
    public String getName();
    public Enemy kill();
    public Enemy clone();
    public long heal(long h);

    public void doDrop();


    public int getExp();
    public long getCoins();

    public String getId();
    public boolean equalsId(String id);

}
