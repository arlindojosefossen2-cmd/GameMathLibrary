package br.com.ajf.game.math.library.point2i;

public class Point2iDistance
{
    private Point2iDistance()
    {
    
    }
    
    public static float distanceLinF(Point2i p1, Point2i p2)
    {
        return Math.max(Math.abs(p1.X()-p2.X()),Math.abs(p1.Y()-p2.Y()));
    }
    
    public static float distanceLi(Point2i p1,Point2i p2)
    {
        return Math.abs(p1.X()-p2.X())+Math.abs(p1.Y()-p2.Y());
    }
    
    public static float distance(Point2i p1,Point2i p2)
    {
        int f = p1.X() - p2.X();
        int f2 = p1.Y() - p2.Y();
        return (float)Math.sqrt(f*f+f2*f2);
    }
    
    public static float distanceSquared(Point2i p1,Point2i p2)
    {
        int f = p1.X() - p2.X();
        int f2 = p1.Y() - p2.Y();
        return f*f+f2*f2;
    }
}