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
}