package br.com.ajf.game.math.library.point2;

import java.io.Serializable;

public interface IPoint2<X> extends Serializable, Cloneable
                                         {
    X x();
    void setX(X x);
    X y();
    void setY(X y);
    void set(X x,X y);
    void set(IPoint2<X> p);
    void clampMin(X n1);
    void clampMax(X n1);
    void clamp(X n1,X n2);
    void clamp(X n1,X n2,IPoint2<X> p);
    void clampMin(X n1,IPoint2<X> p);
    void clampMax(X n1,IPoint2<X> p);
    void absolute(IPoint2<X> p);
    void absolute();
    void negate();
    void negate(IPoint2<X> p);
    void add(IPoint2<X> p);
    void add(IPoint2<X> p1,IPoint2<X> p2);
    void add(X x,X y);
    void sub(IPoint2<X> p);
    void sub(IPoint2<X> p1,IPoint2<X> p2);
    void sub(X x,X y);
    void multiply(IPoint2<X> p);
    void divide(IPoint2<X> p);
    void scale(X x);
    void scale(IPoint2<X> p,X x);
    void scaleAndAdd(IPoint2<X> p,X x);
    void scaleAndAdd(IPoint2<X> p1,IPoint2<X> p2,X x);
    boolean equals(IPoint2<X> p);
}