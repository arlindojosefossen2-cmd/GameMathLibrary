package br.com.ajf.game.math.library.tuples;

import java.io.Serializable;

public interface ITuple3<X> extends Serializable, Cloneable
{
    void get(X[] array);
    void get(ITuple3<X> t);
    void set(X[] array);
    void set(ITuple3<X> t);
    boolean equals(ITuple3<X> t);
    X x();
    void setX(X x);
    X y();
    void setY(X y);
    X z();
    void setZ(X z);
}