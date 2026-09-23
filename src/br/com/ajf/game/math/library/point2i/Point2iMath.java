package br.com.ajf.game.math.library.point2i;

public final class Point2iMath
{
    public float distanceLinF(Point2i p1, Point2i p2)
    {
        return Point2iDistance.distanceLinF(p1,p2);
    }
    
    public float distanceLi(Point2i p1,Point2i p2)
    {
      return Point2iDistance.distanceLi(p1,p2);
    }
    
    public float distance(Point2i p1,Point2i p2)
    {
        return Point2iDistance.distance(p1,p2);
    }
    
    public float distanceSquared(Point2i p1,Point2i p2)
    {
        return Point2iDistance.distanceSquared(p1,p2);
    }
    
    public Point2i interpolate(Point2i p1,Point2i p2,int f)
    {
        return p1.set((int) ((1.0f - f) * p1.X() + f * p2.X()), (int) ((1.0f - f) * p1.Y() + f * p2.Y()));
    }
    
    public Point2i absolute(Point2i p)
    {
        return p.set(Math.abs(p.X()),Math.abs(p.Y()));
    }
    
    public Point2i clampMax(Point2i p1,int f)
    {
        return ClampPoint2i.clampMax(p1,f);
    }
    
    public Point2i clampMin(Point2i p1,int f)
    {
        return ClampPoint2i.clampMin(p1,f);
    }
    
    public Point2i clamp(Point2i p,int f,int f2)
    {
       return ClampPoint2i.clamp(p,f,f2);
    }
    
    public Point2i clamp(Point2i p1,Point2i p2,int f,int f2)
    {
       return ClampPoint2i.clamp(p1,p2,f,f2);
    }
    
    public boolean epsilonEquals(Point2i p1,Point2i p2,int factor)
    {
       return Point2iEpsilonEquals.equals(p1,p2,factor);
    }
    
    public Point2i scale(Point2i p,int factor)
    {
        return multiply(p,factor);
    }
    
    public Point2i scaleAndAddition(Point2i p1,Point2i p2,int factor)
    {
        return p1.set(p1.X()*factor+p2.X(),p1.Y()*factor+p2.Y());
    }
    
    public Point2i scaleAndSubtract(Point2i p1,Point2i p2,int factor)
    {
        return p1.set(p1.X()*factor-p2.X(),p1.Y()*factor-p2.Y());
    }
    
    public Point2i negate(Point2i p)
    {
        return p.set(-p.X(),-p.Y());
    }
    
    public Point2i divide(Point2i p,int factor)
    {
        if(factor == 0)
        {
            return p;
        }
        return p.set(p.X()/factor,p.Y()/factor);
    }
    
    public Point2i divide(Point2i p,int x,int y)
    {
        if(x == 0 || y == 0)
        {
            return p;
        }
        return p.set(p.X()/x,p.Y()/y);
    }
    
    public Point2i divide(Point2i p1,Point2i p2)
    {
        if(p2.X() == 0 || p2.Y() == 0)
        {
            return p1;
        }
        return p1.set(p1.X()/p2.X(),p1.Y()/p2.Y());
    }
    
    public Point2i multiply(Point2i p,int factor)
    {
        return p.set(p.X()*factor,p.Y()*factor);
    }
    
    public Point2i multiply(Point2i p,int x,int y)
    {
        return p.set(p.X()*x,p.Y()*y);
    }
    
    public Point2i multiply(Point2i p1,Point2i p2)
    {
        return p1.set(p1.X()*p2.X(),p1.Y()* p2.Y());
    }
    
    public Point2i addition(Point2i p,int factor)
    {
        return p.set(p.X()+factor,p.Y()+factor);
    }
    
    public Point2i addition(Point2i p,int x,int y)
    {
        return p.set(p.X()+x,p.Y()+y);
    }
    
    public Point2i addition(Point2i p1,Point2i p2)
    {
        return p1.set(p1.X()+p2.X(),p1.Y()+ p2.Y());
    }
    
    public Point2i subtract(Point2i p,int factor)
    {
        return p.set(p.X()-factor,p.Y()-factor);
    }
    
    public Point2i subtract(Point2i p,int x,int y)
    {
        return p.set(p.X()-x,p.Y()-y);
    }
    
    public Point2i subtract(Point2i p1,Point2i p2)
    {
        return p1.set(p1.X()-p2.X(),p1.Y()-p2.Y());
    }
}