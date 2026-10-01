package br.com.ajf.game.math.library.tuples.tmath2;

import br.com.ajf.game.math.library.tuples.tuple2.ITuple2;

public interface TMath2<X>
{
    void clamp(ITuple2<X> p, X n1, X n2);
    void clamp(ITuple2<X> p1,ITuple2<X> p2,X n1, X n2);
    void clampMin(ITuple2<X> p,X n);
    void clampMax(ITuple2<X> p,X n);
    void absolute(ITuple2<X> p);
    void absolute(ITuple2<X> p1,ITuple2<X> p2);
    void negate(ITuple2<X> p);
    void negate(ITuple2<X> p1,ITuple2<X> p2);
    void add(ITuple2<X> p,X v);
    void add(ITuple2<X> p1,ITuple2<X> p2);
    void sub(ITuple2<X> p,X v);
    void sub(ITuple2<X> p1,ITuple2<X> p2);
    void multiply(ITuple2<X> p,X v);
    void multiply(ITuple2<X> p1,ITuple2<X> p2);
    void divide(ITuple2<X> p,X v);
    void divide(ITuple2<X> p1,ITuple2<X> p2);
    void scale(ITuple2<X> p,X s);
    void scaleAndAdd(ITuple2<X> p1,ITuple2<X> p2,X s);
    boolean equals(ITuple2<X> p1,ITuple2<X> p2);
}