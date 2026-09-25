package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.vector3.IVector3;

public interface IVector4<X,Y,Z,W> extends IPoint4<X,Y,Z,W>
{
    void normalize(IVector4<X,Y,Z,W> v);
    
    void normalize();
    
    X angle(IVector4<X,Y,Z,W> v);
    
    X dot(IVector4<X,Y,Z,W> v);
    
    X length();
    
    X lengthSquared();
    
    void set(IVector3<X,X,X> p);
    
    X distance(IVector4<X,Y,Z,W> p);
    
    X distanceL1(IVector4<X,Y,Z,X> p);
    
    X distanceSquared(IVector4<X,Y,Z,W> p);
    
    X distanceLinF(IVector4<X,Y,Z,W> p);
    
    void project(IVector4<X,Y,Z,W> p);
    
    void set(X[] array);
}