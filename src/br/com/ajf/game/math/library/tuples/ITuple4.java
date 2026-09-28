package br.com.ajf.game.math.library.tuples;

import java.io.Serializable;

public interface ITuple4<X> extends Serializable, Cloneable
{
    void get(X[] array);
    void get(ITuple4<X> t);
    void set(X[] array);
    void set(ITuple4<X> t);
    boolean equals(ITuple4<X> t);
    X r();
    void setR(X r);
    X g();
    void setG(X g);
    X b();
    void setB(X b);
    X a();
    void setA(X a);
}