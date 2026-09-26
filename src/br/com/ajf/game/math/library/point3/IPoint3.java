package br.com.ajf.game.math.library.point3;

import java.io.Serializable;

public interface IPoint3<X> extends Serializable, Cloneable
{
    X x();
    void setX(X x);
    X y();
    void setY(X y);
    X z();
    void setZ(X z);
    void set(X x,X y,X z);
    void set(IPoint3<X> p);
    void add(IPoint3<X> p);
    void add(IPoint3<X> p1,IPoint3<X> p2);
    void sub(IPoint3<X> p);
    void sub(IPoint3<X> p1,IPoint3<X> p2);
    void negate();
    void negate(IPoint3<X> p);
    void scale(X x);
    void scale(X x,IPoint3<X> p);
    void scaleAndAdd(X x,IPoint3<X> p1,IPoint3<X> p2);
    void scaleAndAdd(X x,IPoint3<X> p);
    void clamp(X n1,X n2,IPoint3<X> p);
    void clampMin(X n,IPoint3<X> p);
    void clampMax(X n,IPoint3<X> p);
    void absolute();
    void absolute(IPoint3<X> p);
    void clamp(X n1,X n2);
    void clampMin(X n);
    void clampMax(X n);
}