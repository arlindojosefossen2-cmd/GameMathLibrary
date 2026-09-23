package br.com.ajf.game.math.library.vector2f;

import br.com.ajf.game.math.library.point2f.ClampPoint2f;
import br.com.ajf.game.math.library.point2f.Point2fDistance;
import br.com.ajf.game.math.library.point2f.Point2fEpsilonEquals;

public final class Vector2fMath
{
    public float crossProduct(Vector2f v,Vector2f u)
    {
        return v.getX()*u.getY() - v.getY()*u.getX();
    }
    
    public Vector2f polar(Vector2f v,float angle,float radius)
    {
        return new Vector2f(radius*(float) Math.cos(angle),radius*(float) Math.sin(angle));
    }
    
    public float angle(Vector2f v)
    {
        return (float) Math.atan2(v.getY(),v.getX());
    }
    
    public Vector2f perp(Vector2f v)
    {
        return new Vector2f(-v.getY(),v.getX());
    }
    
    public Vector2f invert(Vector2f v)
    {
        return negate(v);
    }
    
    public Vector2f shear(Vector2f v ,float sx,float sy)
    {
        float temp = v.getX()+sx*v.getY();
        v.setY(v.getY()+sy*v.getX());
        v.setX(temp);
        return v;
    }
    
    public Vector2f rotate(Vector2f v,float rad)
    {
        float temp = (float) (v.getX()*Math.cos(rad)-v.getY()*Math.sin(rad));
        v.setY((float)(v.getX()*Math.sin(rad)+v.getY()*Math.cos(rad)));
        v.setX(temp);
        return v;
    }
    
    public float dotProduct(Vector2f v,Vector2f u)
    {
        return v.getX()*u.getX()+v.getY()*u.getY();
    }
    
    public float length(Vector2f v)
    {
        return (float) Math.sqrt(lengthSquared(v));
    }
    
    public float lengthSquared(Vector2f v)
    {
        return v.getX()*v.getX()+v.getY()*v.getY();
    }
    
    public Vector2f normalize(Vector2f v)
    {
        float f = (float)(1.0/length(v));
        return v.set(v.getX()*f,v.getY()*f);
    }
    
    public float angle(Vector2f v,Vector2f u)
    {
        double d = dotProduct(v,u)/(length(v)*length(u));
        if(d < -1.0)
        {
            d = -1.0;
        }
        
        if(d > 1.0)
        {
            d = 1.0;
        }
        return (float) Math.acos(d);
    }
    
    public float distanceLinF(Vector2f v, Vector2f u)
    {
        return Point2fDistance.distanceLinF(v.getPoint2f(),u.getPoint2f());
    }
    
    public float distanceLi(Vector2f v,Vector2f u)
    {
        return Point2fDistance.distanceLi(v.getPoint2f(),u.getPoint2f());
    }
    
    public float distance(Vector2f v,Vector2f u)
    {
        return Point2fDistance.distance(v.getPoint2f(),u.getPoint2f());
    }
    
    public float distanceSquared(Vector2f v,Vector2f u)
    {
        return Point2fDistance.distanceSquared(v.getPoint2f(),u.getPoint2f());
    }
    
    public Vector2f interpolate(Vector2f v,Vector2f u,float f)
    {
        return v.set((1.0f-f)*v.getX()+f*u.getX(),(1.0f-f)*v.getY()+f*u.getY());
    }
    
    public Vector2f absolute(Vector2f v)
    {
        return v.set(Math.abs(v.getX()),Math.abs(v.getY()));
    }
    
    public Vector2f clampMax(Vector2f v,float f)
    {
        return new Vector2f(ClampPoint2f.clampMax(v.getPoint2f(),f));
    }
    
    public Vector2f clampMin(Vector2f v,float f)
    {
        return new Vector2f(ClampPoint2f.clampMin(v.getPoint2f(),f));
    }
    
    public Vector2f clamp(Vector2f v,float f,float f2)
    {
        return new Vector2f(ClampPoint2f.clamp(v.getPoint2f(),f,f2));
    }
    
    public Vector2f clamp(Vector2f v, Vector2f u, float f, float f2)
    {
        return new Vector2f(ClampPoint2f.clamp(v.getPoint2f(), u.getPoint2f(), f, f2));
    }
    
    public boolean epsilonEquals(Vector2f v,Vector2f u,float factor)
    {
        return Point2fEpsilonEquals.equals(v.getPoint2f(),u.getPoint2f(),factor);
    }
    
    public Vector2f scale(Vector2f v,float factor)
    {
        return multiply(v,factor);
    }
    
    public Vector2f scaleAndAddition(Vector2f v,Vector2f u,float factor)
    {
        return v.set(v.getX()*factor+u.getX(),v.getY()*factor+u.getY());
    }
    
    public Vector2f scaleAndSubtract(Vector2f v,Vector2f u,float factor)
    {
        return v.set(v.getX()*factor-u.getX(),v.getY()*factor-u.getY());
    }
    
    public Vector2f negate(Vector2f v)
    {
        return v.set(-v.getX(),-v.getY());
    }
    
    public Vector2f divide(Vector2f v,float factor)
    {
        if(factor == 0)
        {
            return v;
        }
        return v.set(v.getX()/factor,v.getY()/factor);
    }
    
    public Vector2f divide(Vector2f v,float x,float y)
    {
        if(x == 0 || y == 0)
        {
            return v;
        }
        return v.set(v.getX()/x,v.getY()/y);
    }
    
    public Vector2f divide(Vector2f v,Vector2f u)
    {
        if(u.getX() == 0 || u.getY() == 0)
        {
            return v;
        }
        return v.set(v.getX()/u.getX(),v.getY()/u.getY());
    }
    
    public Vector2f multiply(Vector2f v,float factor)
    {
        return v.set(v.getX()*factor,v.getY()*factor);
    }
    
    public Vector2f multiply(Vector2f v,float x,float y)
    {
        return v.set(v.getX()*x,v.getY()*y);
    }
    
    public Vector2f multiply(Vector2f v, Vector2f u)
    {
        return v.set(v.getX()*u.getX(),v.getY()* u.getY());
    }
    
    public Vector2f addition(Vector2f v,float factor)
    {
        return v.set(v.getX()+factor,v.getY()+factor);
    }
    
    public Vector2f addition(Vector2f v,float x,float y)
    {
        return v.set(v.getX()+x,v.getY()+y);
    }
    
    public Vector2f addition(Vector2f v,Vector2f u)
    {
        return v.set(v.getX()+u.getX(),v.getY()+ u.getY());
    }
    
    public Vector2f subtract(Vector2f v,float factor)
    {
        return v.set(v.getX()-factor,v.getY()-factor);
    }
    
    public Vector2f subtract(Vector2f v,float x,float y)
    {
        return v.set(v.getX()-x,v.getY()-y);
    }
    
    public Vector2f subtract(Vector2f v,Vector2f u)
    {
        return v.set(v.getY()-u.getX(),v.getY()-u.getY());
    }
}