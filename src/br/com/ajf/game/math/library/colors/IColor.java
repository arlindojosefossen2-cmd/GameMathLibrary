package br.com.ajf.game.math.library.colors;

import java.io.Serializable;

public interface IColor<X> extends Serializable,Cloneable
{
    void get(IColor<X> t);
    void set(IColor<X> t);
    boolean equals(IColor<X> t);
    X red();
    void setRed(X r);
    X green();
    void setGreen(X g);
    X blue();
    void setBlue(X b);
    X alpha();
    void setAlpha(X a);
}