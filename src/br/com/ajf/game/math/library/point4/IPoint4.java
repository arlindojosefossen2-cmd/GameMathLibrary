package br.com.ajf.game.math.library.point4;

import java.io.Serializable;

public interface IPoint4<X,Y,Z,W> extends Serializable, Cloneable
{
    X x();
    void setX(X x);
    Y y();
    void setY(Y y);
    Z z();
    void setZ(Z z);
    W w();
    void setW(W w);
    boolean equals(IPoint4<X,Y,Z,W> p);
    void set(X x,Y y,Z z,W w);
    void set(IPoint4<X,Y,Z,W> p);
    void add(IPoint4<X,Y,Z,W> p);
    void add(IPoint4<X,Y,Z,W> p1,IPoint4<X,Y,Z,W> p2);
    void sub(IPoint4<X,Y,Z,W> p);
    void sub(IPoint4<X,Y,Z,W> p1,IPoint4<X,Y,Z,W> p2);
    void negate();
    void negate(IPoint4<X,Y,Z,W> p);
    void scale(X x);
    void scale(X x,IPoint4<X,Y,Z,W> p);
    void scaleAndAdd(X x,IPoint4<X,Y,Z,W> p);
    void scaleAndAdd(X x,IPoint4<X,Y,Z,W> p1,IPoint4<X,Y,Z,W> p2);
    void clamp(X n1,X n2,IPoint4<X,Y,Z,W> p);
    void clampMin(X n,IPoint4<X,Y,Z,W> p);
    void clampMax(X n,IPoint4<X,Y,Z,W> p);
    void absolute();
    void absolute(IPoint4<X,Y,Z,W> p);
    void clamp(X n1,X n2);
    void clampMin(X n);
    void clampMax(X n);
}