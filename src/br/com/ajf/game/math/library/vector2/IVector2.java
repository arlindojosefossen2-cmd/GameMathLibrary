package br.com.ajf.game.math.library.vector2;

import br.com.ajf.game.math.library.point2.IPoint2;

public interface IVector2<X,Y> extends IPoint2<X,Y>
{
    X lengthSquared();
    
    void normalize();
    
    X angle(IVector2<X,Y> v);
    
    void normalize(IVector2<X,Y> v);
    
    X dot(IVector2<X,Y> v);
    
    X length();
    
    void interpolate(IPoint2<X,Y> p,X n);
    
    void interpolate(IPoint2<X,Y> p1,IPoint2<X,Y> p2,X n);
    
    boolean epsilonEquals(IPoint2<X,Y> p,X f);
    
    X distanceSquared(IPoint2<X,Y> p);
    
    X distance(IPoint2<X,Y> p);
    
    X distanceL1(IPoint2<X,Y> p);
    
    X distanceLinF(IPoint2<X,Y> p);
}