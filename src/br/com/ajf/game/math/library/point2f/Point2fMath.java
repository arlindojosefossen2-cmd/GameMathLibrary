package br.com.ajf.game.math.library.point2f;

public final class Point2fMath
{
    public float distanceLinF(Point2f p1,Point2f p2)
    {
        return Point2fDistance.distanceLinF(p1,p2);
    }
    
    public float distanceLi(Point2f p1,Point2f p2)
    {
      return Point2fDistance.distanceLi(p1,p2);
    }
    
    public float distance(Point2f p1,Point2f p2)
    {
        return Point2fDistance.distance(p1,p2);
    }
    
    public float distanceSquared(Point2f p1,Point2f p2)
    {
        return Point2fDistance.distanceSquared(p1,p2);
    }
    
    public Point2f interpolate(Point2f p1,Point2f p2,float f)
    {
        return p1.set((1.0f-f)*p1.X()+f*p2.X(),(1.0f-f)*p1.Y()+f*p2.Y());
    }
    
    public Point2f absolute(Point2f p)
    {
        return p.set(Math.abs(p.X()),Math.abs(p.Y()));
    }
    
    public Point2f clampMax(Point2f p1,float f)
    {
        return ClampPoint2f.clampMax(p1,f);
    }
    
    public Point2f clampMin(Point2f p1,float f)
    {
        return ClampPoint2f.clampMin(p1,f);
    }
    
    public Point2f clamp(Point2f p,float f,float f2)
    {
       return ClampPoint2f.clamp(p,f,f2);
    }
    
    public Point2f clamp(Point2f p1,Point2f p2,float f,float f2)
    {
       return ClampPoint2f.clamp(p1,p2,f,f2);
    }
    
    public boolean epsilonEquals(Point2f p1,Point2f p2,float factor)
    {
       return Point2fEpsilonEquals.equals(p1,p2,factor);
    }
    
    public Point2f scale(Point2f p,float factor)
    {
        return multiply(p,factor);
    }
    
    public Point2f scaleAndAddition(Point2f p1,Point2f p2,float factor)
    {
        return p1.set(p1.X()*factor+p2.X(),p1.Y()*factor+p2.Y());
    }
    
    public Point2f scaleAndSubtract(Point2f p1,Point2f p2,float factor)
    {
        return p1.set(p1.X()*factor-p2.X(),p1.Y()*factor-p2.Y());
    }
    
    public Point2f negate(Point2f p)
    {
        return p.set(-p.X(),-p.Y());
    }
    
    public Point2f divide(Point2f p,float factor)
    {
        if(factor == 0)
        {
            return p;
        }
        return p.set(p.X()/factor,p.Y()/factor);
    }
    
    public Point2f divide(Point2f p,float x,float y)
    {
        if(x == 0 || y == 0)
        {
            return p;
        }
        return p.set(p.X()/x,p.Y()/y);
    }
    
    public Point2f divide(Point2f p1,Point2f p2)
    {
        if(p2.X() == 0 || p2.Y() == 0)
        {
            return p1;
        }
        return p1.set(p1.X()/p2.X(),p1.Y()/p2.Y());
    }
    
    public Point2f multiply(Point2f p,float factor)
    {
        return p.set(p.X()*factor,p.Y()*factor);
    }
    
    public Point2f multiply(Point2f p,float x,float y)
    {
        return p.set(p.X()*x,p.Y()*y);
    }
    
    public Point2f multiply(Point2f p1,Point2f p2)
    {
        return p1.set(p1.X()*p2.X(),p1.Y()* p2.Y());
    }
    
    public Point2f addition(Point2f p,float factor)
    {
        return p.set(p.X()+factor,p.Y()+factor);
    }
    
    public Point2f addition(Point2f p,float x,float y)
    {
        return p.set(p.X()+x,p.Y()+y);
    }
    
    public Point2f addition(Point2f p1,Point2f p2)
    {
        return p1.set(p1.X()+p2.X(),p1.Y()+ p2.Y());
    }
    
    public Point2f subtract(Point2f p,float factor)
    {
        return p.set(p.X()-factor,p.Y()-factor);
    }
    
    public Point2f subtract(Point2f p,float x,float y)
    {
        return p.set(p.X()-x,p.Y()-y);
    }
    
    public Point2f subtract(Point2f p1,Point2f p2)
    {
        return p1.set(p1.X()-p2.X(),p1.Y()-p2.Y());
    }
}