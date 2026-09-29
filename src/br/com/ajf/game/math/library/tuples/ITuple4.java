package br.com.ajf.game.math.library.tuples;

import java.io.Serializable;

public interface ITuple4<X> extends Serializable, Cloneable
{
    void get(X[] array);
    void get(ITuple4<X> t);
    void set(X[] array);
    void set(ITuple4<X> t);
    boolean equals(ITuple4<X> t);
    X x();
    void setX(X r);
    X y();
    void setY(X g);
    X z();
    void setZ(X b);
    X w();
    void setW(X a);
}