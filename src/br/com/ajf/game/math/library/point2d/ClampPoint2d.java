package br.com.ajf.game.math.library.point2d;

public final class ClampPoint2d
{
    private ClampPoint2d()
    {
    
    }
    
    public static Point2d clampMax(Point2d p1, double f)
    {
        return p1.setX(Math.max(p1.X(), f))
                       .setY(Math.max(p1.Y(), f));
    }
    
    public static Point2d clampMin(Point2d p1,double f)
    {
        return p1.setX(Math.min(p1.X(), f))
                       .setY(Math.min(p1.Y(), f));
    }
    
    public static Point2d clamp(Point2d p,double f,double f2)
    {
        if(p.X() > f2)
        {
            p.setX(f2);
        }
        else if(p.X() < f)
        {
            p.setX(f);
        }
        
        if(p.Y() > f2)
        {
            p.setY(f2);
        }
        else if(p.Y() < f)
        {
            p.setY(f);
        }
        
        return p;
    }
    
    public static Point2d clamp(Point2d p1,Point2d p2,double f,double f2)
    {
        return p1.setX(p2.X() > f2 ? f2 : Math.max(p2.X(), f))
                       .setY(p2.Y() > f2 ? f2 : (Math.max(p2.Y(), f)));
    }
}