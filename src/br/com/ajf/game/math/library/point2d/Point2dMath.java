package br.com.ajf.game.math.library.point2d;


public final class Point2dMath
{
    public double distanceLinF(Point2d p1, Point2d p2)
    {
        return Point2dDistance.distanceLinF(p1,p2);
    }
    
    public double distanceLi(Point2d p1,Point2d p2)
    {
      return Point2dDistance.distanceLi(p1,p2);
    }
    
    public double distance(Point2d p1,Point2d p2)
    {
        return Point2dDistance.distance(p1,p2);
    }
    
    public double distanceSquared(Point2d p1,Point2d p2)
    {
        return Point2dDistance.distanceSquared(p1,p2);
    }
    
    public Point2d interpolate(Point2d p1,Point2d p2,double f)
    {
        return p1.set((1.0f-f)*p1.X()+f*p2.X(),(1.0f-f)*p1.Y()+f*p2.Y());
    }
    
    public Point2d absolute(Point2d p)
    {
        return p.set(Math.abs(p.X()),Math.abs(p.Y()));
    }
    
    public Point2d clampMax(Point2d p1,double f)
    {
        return ClampPoint2d.clampMax(p1,f);
    }
    
    public Point2d clampMin(Point2d p1,double f)
    {
        return ClampPoint2d.clampMin(p1,f);
    }
    
    public Point2d clamp(Point2d p,double f,double f2)
    {
       return ClampPoint2d.clamp(p,f,f2);
    }
    
    public Point2d clamp(Point2d p1,Point2d p2,double f,double f2)
    {
       return ClampPoint2d.clamp(p1,p2,f,f2);
    }
    
    public boolean epsilonEquals(Point2d p1,Point2d p2,double factor)
    {
       return Point2dEpsilonEquals.equals(p1,p2,factor);
    }
    
    public Point2d scale(Point2d p,double factor)
    {
        return multiply(p,factor);
    }
    
    public Point2d scaleAndAddition(Point2d p1,Point2d p2,double factor)
    {
        return p1.set(p1.X()*factor+p2.X(),p1.Y()*factor+p2.Y());
    }
    
    public Point2d scaleAndSubtract(Point2d p1,Point2d p2,double factor)
    {
        return p1.set(p1.X()*factor-p2.X(),p1.Y()*factor-p2.Y());
    }
    
    public Point2d negate(Point2d p)
    {
        return p.set(-p.X(),-p.Y());
    }
    
    public Point2d divide(Point2d p,double factor)
    {
        if(factor == 0)
        {
            return p;
        }
        return p.set(p.X()/factor,p.Y()/factor);
    }
    
    public Point2d divide(Point2d p,double x,double y)
    {
        if(x == 0 || y == 0)
        {
            return p;
        }
        return p.set(p.X()/x,p.Y()/y);
    }
    
    public Point2d divide(Point2d p1,Point2d p2)
    {
        if(p2.X() == 0 || p2.Y() == 0)
        {
            return p1;
        }
        return p1.set(p1.X()/p2.X(),p1.Y()/p2.Y());
    }
    
    public Point2d multiply(Point2d p,double factor)
    {
        return p.set(p.X()*factor,p.Y()*factor);
    }
    
    public Point2d multiply(Point2d p,double x,double y)
    {
        return p.set(p.X()*x,p.Y()*y);
    }
    
    public Point2d multiply(Point2d p1,Point2d p2)
    {
        return p1.set(p1.X()*p2.X(),p1.Y()* p2.Y());
    }
    
    public Point2d addition(Point2d p,double factor)
    {
        return p.set(p.X()+factor,p.Y()+factor);
    }
    
    public Point2d addition(Point2d p,double x,double y)
    {
        return p.set(p.X()+x,p.Y()+y);
    }
    
    public Point2d addition(Point2d p1,Point2d p2)
    {
        return p1.set(p1.X()+p2.X(),p1.Y()+ p2.Y());
    }
    
    public Point2d subtract(Point2d p,double factor)
    {
        return p.set(p.X()-factor,p.Y()-factor);
    }
    
    public Point2d subtract(Point2d p,double x,double y)
    {
        return p.set(p.X()-x,p.Y()-y);
    }
    
    public Point2d subtract(Point2d p1,Point2d p2)
    {
        return p1.set(p1.X()-p2.X(),p1.Y()-p2.Y());
    }
}