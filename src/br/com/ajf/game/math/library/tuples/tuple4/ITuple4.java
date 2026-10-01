package br.com.ajf.game.math.library.tuples.tuple4;

import br.com.ajf.game.math.library.tuples.tuple3.ITuple3;

import java.io.Serializable;

public interface ITuple4<X> extends ITuple3<X>, Serializable, Cloneable
{
    void get(ITuple4<X> t);
    void set(ITuple4<X> t);
    boolean equals(ITuple4<X> t);
    ITuple4<X> clone();
    X w();
    void setW(X a);
}