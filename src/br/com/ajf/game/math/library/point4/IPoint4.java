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
}