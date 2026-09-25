package br.com.ajf.game.math.library.vector3;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;

public interface IVector3<X,Y,Z> extends IPoint3<X,Y,Z>
{
    void normalize(IVector3<X,Y,Z> v);
    
    void normalize();
    
    X angle(IVector3<X,Y,Z> v);
    
    X lengthSquared();
    
    X length();
    
    void cross(IVector3<X,Y,Z> v,IVector3<X,Y,Z> u);
    
    X dot(IVector3<X,Y,Z> v);
    
    X distanceSquared(IPoint3<X,Y,Z> p);
    
    X distance(IPoint3<X,Y,Z> p);
    
    X distanceL1(IPoint3<X,Y,Z> p);
    X distanceLinF(IPoint3<X,Y,Z> p);
    
    void project(IPoint4<X,Y,Z,X> p);
    
    void interpolate(IPoint3<X,Y,Z> p1,IPoint3<X,Y,Z> p2,X f);
    
    void interpolate(IPoint3<X,Y,Z> p,X f);
    
    boolean epsilonEquals(IPoint3<X,Y,Z> p,X f);
}