package br.com.ajf.game.math.library.point2f;

public final class ClampPoint2f
{
    private ClampPoint2f()
    {
    
    }
    
    public static Point2f clampMax(Point2f p1, float f)
    {
        return p1.setX(Math.max(p1.X(), f))
                       .setY(Math.max(p1.Y(), f));
    }
    
    public static Point2f clampMin(Point2f p1,float f)
    {
        return p1.setX(Math.min(p1.X(), f))
                       .setY(Math.min(p1.Y(), f));
    }
    
    public static Point2f clamp(Point2f p,float f,float f2)
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
    
    public static Point2f clamp(Point2f p1,Point2f p2,float f,float f2)
    {
        return p1.setX(p2.X() > f2 ? f2 : Math.max(p2.X(), f))
                       .setY(p2.Y() > f2 ? f2 : (Math.max(p2.Y(), f)));
    }
}