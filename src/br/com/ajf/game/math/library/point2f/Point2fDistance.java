package br.com.ajf.game.math.library.point2f;

public final class Point2fDistance
{
    private Point2fDistance()
    {
    
    }
    
    public static float distanceLinF(Point2f p1,Point2f p2)
    {
        return Math.max(Math.abs(p1.X()-p2.X()),Math.abs(p1.Y()-p2.Y()));
    }
    
    public static float distanceLi(Point2f p1,Point2f p2)
    {
        return Math.abs(p1.X()-p2.X())+Math.abs(p1.Y()-p2.Y());
    }
    
    public static float distance(Point2f p1,Point2f p2)
    {
        float f = p1.X() - p2.X();
        float f2 = p1.Y() - p2.Y();
        return (float)Math.sqrt(f*f+f2*f2);
    }
    
    public static float distanceSquared(Point2f p1,Point2f p2)
    {
        float f = p1.X() - p2.X();
        float f2 = p1.Y() - p2.Y();
        return f*f+f2*f2;
    }
}