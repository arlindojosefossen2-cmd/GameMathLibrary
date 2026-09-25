package br.com.ajf.game.math.library.point3;

import java.io.Serializable;

public interface IPoint3<X,Y,Z> extends Serializable, Cloneable
{
    X x();
    void setX(X x);
    Y y();
    void setY(Y y);
    Z z();
    void setZ(Z z);
    void set(X x,Y y,Z z);
    void set(IPoint3<X,Y,Z> p);
    void add(IPoint3<X,Y,Z> p);
    void add(IPoint3<X,Y,Z> p1,IPoint3<X,Y,Z> p2);
    void sub(IPoint3<X,Y,Z> p);
    void sub(IPoint3<X,Y,Z> p1,IPoint3<X,Y,Z> p2);
    void negate();
    void negate(IPoint3<X,Y,Z> p);
    void scale(X x);
    void scale(X x,IPoint3<X,Y,Z> p);
    void scaleAndAdd(X x,IPoint3<X,Y,Z> p1,IPoint3<X,Y,Z> p2);
    void scaleAndAdd(X x,IPoint3<X,Y,Z> p);
    void clamp(X n1,X n2,IPoint3<X,Y,Z> p);
    void clampMin(X n,IPoint3<X,Y,Z> p);
    void clampMax(X n,IPoint3<X,Y,Z> p);
    void absolute();
    void absolute(IPoint3<X,Y,Z> p);
    void clamp(X n1,X n2);
    void clampMin(X n);
    void clampMax(X n);
}