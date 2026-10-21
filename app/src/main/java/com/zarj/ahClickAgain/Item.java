package com.zarj.ahClickAgain;

import java.io.Serializable;

public interface Item extends Serializable, Imagable {
    public String getName();

    public String getId();
}
