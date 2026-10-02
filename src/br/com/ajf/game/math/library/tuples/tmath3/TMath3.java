package br.com.ajf.game.math.library.tuples.tmath3;

import br.com.ajf.game.math.library.tuples.tuple3.ITuple3;

public interface TMath3<X>
{
    X distanceSquared(ITuple3<X> p1, ITuple3<X> p2);
    X distance(ITuple3<X> p1,ITuple3<X> p2);
    X distanceL1(ITuple3<X> p1,ITuple3<X> p2);
    X distanceLinF(ITuple3<X> p1,ITuple3<X> p2);
    void clamp(ITuple3<X> p, X n1, X n2);
    void clamp(ITuple3<X> p1,ITuple3<X> p2,X n1, X n2);
    void clampMin(ITuple3<X> p,X n);
    void clampMax(ITuple3<X> p,X n);
    void absolute(ITuple3<X> p);
    void absolute(ITuple3<X> p1,ITuple3<X> p2);
    void negate(ITuple3<X> p);
    void negate(ITuple3<X> p1,ITuple3<X> p2);
    void add(ITuple3<X> p,X v);
    void add(ITuple3<X> p1,ITuple3<X> p2);
    void sub(ITuple3<X> p,X v);
    void sub(ITuple3<X> p1,ITuple3<X> p2);
    void multiply(ITuple3<X> p,X v);
    void multiply(ITuple3<X> p1,ITuple3<X> p2);
    void divide(ITuple3<X> p,X v);
    void divide(ITuple3<X> p1,ITuple3<X> p2);
    void scale(ITuple3<X> p,X s);
    void scaleAndAdd(ITuple3<X> p1,ITuple3<X> p2,X s);
    boolean equals(ITuple3<X> p1,ITuple3<X> p2);
}