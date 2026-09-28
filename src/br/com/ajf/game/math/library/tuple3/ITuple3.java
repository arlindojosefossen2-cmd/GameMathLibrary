package br.com.ajf.game.math.library.tuple3;

import java.io.Serializable;

public interface ITuple3<X> extends Serializable, Cloneable
{
    void get(X[] array);
    void get(ITuple3<X> t);
    void set(X[] array);
    void set(ITuple3<X> t);
    boolean equals(ITuple3<X> t);
    X r();
    void setR(X x);
    X g();
    void setG(X y);
    X b();
    void setB(X z);
}