package br.com.ajf.game.math.library.vector2d;

import br.com.ajf.game.math.library.point2d.ClampPoint2d;
import br.com.ajf.game.math.library.point2d.Point2dDistance;
import br.com.ajf.game.math.library.point2d.Point2dEpsilonEquals;

public final class Vector2dMath
{
    public double crossProduct(Vector2d v, Vector2d u)
    {
        return v.getX()*u.getY() - v.getY()*u.getX();
    }
    
    public Vector2d polar(Vector2d v,double angle,double radius)
    {
        return new Vector2d(radius*Math.cos(angle),radius*Math.sin(angle));
    }
    
    public double angle(Vector2d v)
    {
        return Math.atan2(v.getY(),v.getX());
    }
    
    public Vector2d perp(Vector2d v)
    {
        return new Vector2d(-v.getY(),v.getX());
    }
    
    public Vector2d invert(Vector2d v)
    {
        return negate(v);
    }
    
    public Vector2d shear(Vector2d v ,double sx,double sy)
    {
        double temp = v.getX()+sx*v.getY();
        v.setY(v.getY()+sy*v.getX());
        v.setX(temp);
        return v;
    }
    
    public Vector2d rotate(Vector2d v,double rad)
    {
        double temp = (v.getX()*Math.cos(rad)-v.getY()*Math.sin(rad));
        v.setY((v.getX()*Math.sin(rad)+v.getY()*Math.cos(rad)));
        v.setX(temp);
        return v;
    }
    
    public double dotProduct(Vector2d v,Vector2d u)
    {
        return v.getX()*u.getX()+v.getY()*u.getY();
    }
    
    public double length(Vector2d v)
    {
        return Math.sqrt(lengthSquared(v));
    }
    
    public double lengthSquared(Vector2d v)
    {
        return v.getX()*v.getX()+v.getY()*v.getY();
    }
    
    public Vector2d normalize(Vector2d v)
    {
        double f = (1.0/length(v));
        return v.set(v.getX()*f,v.getY()*f);
    }
    
    public double angle(Vector2d v,Vector2d u)
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
        return Math.acos(d);
    }
    
    public double distanceLinF(Vector2d v, Vector2d u)
    {
        return Point2dDistance.distanceLinF(v.getPoint2d(),u.getPoint2d());
    }
    
    public double distanceLi(Vector2d v,Vector2d u)
    {
        return Point2dDistance.distanceLi(v.getPoint2d(),u.getPoint2d());
    }
    
    public double distance(Vector2d v,Vector2d u)
    {
        return Point2dDistance.distance(v.getPoint2d(),u.getPoint2d());
    }
    
    public double distanceSquared(Vector2d v,Vector2d u)
    {
        return Point2dDistance.distanceSquared(v.getPoint2d(),u.getPoint2d());
    }
    
    public Vector2d interpolate(Vector2d v,Vector2d u,double f)
    {
        return v.set((1.0f-f)*v.getX()+f*u.getX(),(1.0f-f)*v.getY()+f*u.getY());
    }
    
    public Vector2d absolute(Vector2d v)
    {
        return v.set(Math.abs(v.getX()),Math.abs(v.getY()));
    }
    
    public Vector2d clampMax(Vector2d v,double f)
    {
        return new Vector2d(ClampPoint2d.clampMax(v.getPoint2d(),f));
    }
    
    public Vector2d clampMin(Vector2d v,double f)
    {
        return new Vector2d(ClampPoint2d.clampMin(v.getPoint2d(),f));
    }
    
    public Vector2d clamp(Vector2d v,double f,double f2)
    {
        return new Vector2d(ClampPoint2d.clamp(v.getPoint2d(),f,f2));
    }
    
    public Vector2d clamp(Vector2d v, Vector2d u, double f, double f2)
    {
        return new Vector2d(ClampPoint2d.clamp(v.getPoint2d(), u.getPoint2d(), f, f2));
    }
    
    public boolean epsilonEquals(Vector2d v,Vector2d u,double factor)
    {
        return Point2dEpsilonEquals.equals(v.getPoint2d(),u.getPoint2d(),factor);
    }
    
    public Vector2d scale(Vector2d v,double factor)
    {
        return multiply(v,factor);
    }
    
    public Vector2d scaleAndAddition(Vector2d v,Vector2d u,double factor)
    {
        return v.set(v.getX()*factor+u.getX(),v.getY()*factor+u.getY());
    }
    
    public Vector2d scaleAndSubtract(Vector2d v,Vector2d u,double factor)
    {
        return v.set(v.getX()*factor-u.getX(),v.getY()*factor-u.getY());
    }
    
    public Vector2d negate(Vector2d v)
    {
        return v.set(-v.getX(),-v.getY());
    }
    
    public Vector2d divide(Vector2d v,double factor)
    {
        if(factor == 0)
        {
            return v;
        }
        return v.set(v.getX()/factor,v.getY()/factor);
    }
    
    public Vector2d divide(Vector2d v,double x,double y)
    {
        if(x == 0 || y == 0)
        {
            return v;
        }
        return v.set(v.getX()/x,v.getY()/y);
    }
    
    public Vector2d divide(Vector2d v,Vector2d u)
    {
        if(u.getX() == 0 || u.getY() == 0)
        {
            return v;
        }
        return v.set(v.getX()/u.getX(),v.getY()/u.getY());
    }
    
    public Vector2d multiply(Vector2d v,double factor)
    {
        return v.set(v.getX()*factor,v.getY()*factor);
    }
    
    public Vector2d multiply(Vector2d v,double x,double y)
    {
        return v.set(v.getX()*x,v.getY()*y);
    }
    
    public Vector2d multiply(Vector2d v, Vector2d u)
    {
        return v.set(v.getX()*u.getX(),v.getY()* u.getY());
    }
    
    public Vector2d addition(Vector2d v,double factor)
    {
        return v.set(v.getX()+factor,v.getY()+factor);
    }
    
    public Vector2d addition(Vector2d v,double x,double y)
    {
        return v.set(v.getX()+x,v.getY()+y);
    }
    
    public Vector2d addition(Vector2d v,Vector2d u)
    {
        return v.set(v.getX()+u.getX(),v.getY()+ u.getY());
    }
    
    public Vector2d subtract(Vector2d v,double factor)
    {
        return v.set(v.getX()-factor,v.getY()-factor);
    }
    
    public Vector2d subtract(Vector2d v,double x,double y)
    {
        return v.set(v.getX()-x,v.getY()-y);
    }
    
    public Vector2d subtract(Vector2d v,Vector2d u)
    {
        return v.set(v.getY()-u.getX(),v.getY()-u.getY());
    }
}