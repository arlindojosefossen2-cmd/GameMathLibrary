package br.com.ajf.game.math.library.point4;

import java.io.Serializable;

public interface IPoint4<X> extends Serializable, Cloneable
{
    X x();
    void setX(X x);
    X y();
    void setY(X y);
    X z();
    void setZ(X z);
    X w();
    void setW(X w);
    boolean equals(IPoint4<X> p);
    void set(X x,X y,X z,X w);
    void set(IPoint4<X> p);
    void add(IPoint4<X> p);
    void add(IPoint4<X> p1,IPoint4<X> p2);
    void sub(IPoint4<X> p);
    void sub(IPoint4<X> p1,IPoint4<X> p2);
    void negate();
    void negate(IPoint4<X> p);
    void scale(X x);
    void scale(X x,IPoint4<X> p);
    void scaleAndAdd(X x,IPoint4<X> p);
    void scaleAndAdd(X x,IPoint4<X> p1,IPoint4<X> p2);
    void clamp(X n1,X n2,IPoint4<X> p);
    void clampMin(X n,IPoint4<X> p);
    void clampMax(X n,IPoint4<X> p);
    void absolute();
    void absolute(IPoint4<X> p);
    void clamp(X n1,X n2);
    void clampMin(X n);
    void clampMax(X n);
}