package com.zarj.ahClickAgain.utils;

import com.zarj.ahClickAgain.items.effects.LiveEffect;

public class TempVals {


    public static LiveEffect effect = new LiveEffect("dmg_buff_1", 20);
    public static String  eff_text = "effect "+effect.getId()+" time "+effect.timeSec();


}
