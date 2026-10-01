package br.com.ajf.game.math.library.tuples.tuple3;

import br.com.ajf.game.math.library.tuples.tuple2.ITuple2;

import java.io.Serializable;

public interface ITuple3<X> extends ITuple2<X>, Serializable, Cloneable
{
    void get(ITuple3<X> t);
    void set(ITuple3<X> t);
    boolean equals(ITuple3<X> t);
    ITuple3<X> clone();
    X z();
    void setZ(X z);
}