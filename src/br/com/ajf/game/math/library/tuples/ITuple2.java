package br.com.ajf.game.math.library.tuples;

import java.io.Serializable;

public interface ITuple2<X> extends Serializable,Cloneable
{
    void set(X[] array);
    void set(ITuple2<X> t);
    void get(X[] array);
    void get(ITuple2<X> t);
    boolean equals(ITuple2<X> t);
    ITuple2<X> clone();
    X x();
    void setX(X x);
    X y();
    void setY(X y);
}