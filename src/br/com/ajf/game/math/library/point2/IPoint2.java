package br.com.ajf.game.math.library.point2;

import java.io.Serializable;

public interface IPoint2<X,Y> extends Serializable, Cloneable
                                         {
    X x();
    void setX(X x);
    Y y();
    void setY(Y y);
    void set(X x,Y y);
    void set(IPoint2<X,Y> p);
    void clampMin(X n1);
    void clampMax(X n1);
    void clamp(X n1,Y n2);
    void clamp(X n1,Y n2,IPoint2<X,Y> p);
    void clampMin(X n1,IPoint2<X,Y> p);
    void clampMax(X n1,IPoint2<X,Y> p);
    void absolute(IPoint2<X,Y> p);
    void absolute();
    void negate();
    void negate(IPoint2<X,Y> p);
    void add(IPoint2<X,Y> p);
    void add(IPoint2<X,Y> p1,IPoint2<X,Y> p2);
    void add(X x,Y y);
    void sub(IPoint2<X,Y> p);
    void sub(IPoint2<X,Y> p1,IPoint2<X,Y> p2);
    void sub(X x,Y y);
    void multiply(IPoint2<X,Y> p);
    void divide(IPoint2<X,Y> p);
    void scale(X x);
    void scale(IPoint2<X,Y> p,X x);
    void scaleAndAdd(IPoint2<X,Y> p,X x);
    void scaleAndAdd(IPoint2<X,Y> p1,IPoint2<X,Y> p2,X x);
    boolean equals(IPoint2<X,Y> p);
}