package br.com.ajf.game.math.library.colors;

import java.io.Serializable;

public interface IColorRGB<X> extends Serializable, Cloneable
{
    void get(IColorRGB<X> t);
    void set(IColorRGB<X> t);
    boolean equals(IColorRGB<X> t);
    X red();
    void setRed(X r);
    X green();
    void setGreen(X g);
    X blue();
    void setBlue(X b);
}