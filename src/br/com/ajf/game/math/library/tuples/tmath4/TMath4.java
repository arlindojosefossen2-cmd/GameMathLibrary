package br.com.ajf.game.math.library.tuples.tmath4;

import br.com.ajf.game.math.library.tuples.tuple4.ITuple4;

public interface TMath4<X>
{
    X distanceSquared(ITuple4<X> p1, ITuple4<X> p2);
    X distance(ITuple4<X> p1,ITuple4<X> p2);
    X distanceL1(ITuple4<X> p1,ITuple4<X> p2);
    X distanceLinF(ITuple4<X> p1,ITuple4<X> p2);
    void clamp(ITuple4<X> p, X n1, X n2);
    void clamp(ITuple4<X> p1,ITuple4<X> p2,X n1, X n2);
    void clampMin(ITuple4<X> p, X n);
    void clampMax(ITuple4<X> p,X n);
    void absolute(ITuple4<X> p);
    void absolute(ITuple4<X> p1,ITuple4<X> p2);
    void negate(ITuple4<X> p);
    void negate(ITuple4<X> p1,ITuple4<X> p2);
    void add(ITuple4<X> p,X v);
    void add(ITuple4<X> p1,ITuple4<X> p2);
    void sub(ITuple4<X> p,X v);
    void sub(ITuple4<X> p1,ITuple4<X> p2);
    void multiply(ITuple4<X> p,X v);
    void multiply(ITuple4<X> p1,ITuple4<X> p2);
    void divide(ITuple4<X> p,X v);
    void divide(ITuple4<X> p1,ITuple4<X> p2);
    void scale(ITuple4<X> p,X s);
    void scaleAndAdd(ITuple4<X> p1,ITuple4<X> p2,X s);
    boolean equals(ITuple4<X> p1,ITuple4<X> p2);
}