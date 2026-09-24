package br.com.ajf.game.math.library.point2;

public interface IPoint2<X,Y>
{
    void clamp(X n1,Y n2);
    void negate();
    void negate(Point2<X,Y> p);
    void add(Point2<X,Y> p);
    void sub(Point2<X,Y> p);
    void multiply(Point2<X,Y> p);
    void divide(Point2<X,Y> p);
}