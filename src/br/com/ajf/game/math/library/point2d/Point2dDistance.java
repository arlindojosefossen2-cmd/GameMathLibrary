package br.com.ajf.game.math.library.point2d;

public final class Point2dDistance
{
    private Point2dDistance()
    {
    
    }
    
    public static double distanceLinF(Point2d p1, Point2d p2)
    {
        return Math.max(Math.abs(p1.X()-p2.X()),Math.abs(p1.Y()-p2.Y()));
    }
    
    public static double distanceLi(Point2d p1,Point2d p2)
    {
        return Math.abs(p1.X()-p2.X())+Math.abs(p1.Y()-p2.Y());
    }
    
    public static double distance(Point2d p1,Point2d p2)
    {
        double f = p1.X() - p2.X();
        double f2 = p1.Y() - p2.Y();
        return Math.sqrt(f*f+f2*f2);
    }
    
    public static double distanceSquared(Point2d p1,Point2d p2)
    {
        double f = p1.X() - p2.X();
        double f2 = p1.Y() - p2.Y();
        return f*f+f2*f2;
    }
}