package br.com.ajf.game.math.library.point2i;

import br.com.ajf.game.math.library.point2f.Point2f;

public class ClampPoint2i
{
    private ClampPoint2i()
    {
    
    }
    
    public static Point2i clampMax(Point2i p1, int f)
    {
        return p1.setX(Math.max(p1.X(), f))
                       .setY(Math.max(p1.Y(), f));
    }
    
    public static Point2i clampMin(Point2i p1,int f)
    {
        return p1.setX(Math.min(p1.X(), f))
                       .setY(Math.min(p1.Y(), f));
    }
    
    public static Point2i clamp(Point2i p,int f,int f2)
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
    
    public static Point2i clamp(Point2i p1,Point2i p2,int f,int f2)
    {
        return p1.setX(p2.X() > f2 ? f2 : Math.max(p2.X(), f))
                       .setY(p2.Y() > f2 ? f2 : (Math.max(p2.Y(), f)));
    }
}