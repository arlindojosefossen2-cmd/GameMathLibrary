package br.com.ajf.game.math.library.point2d;

public final class Point2dEpsilonEquals
{
    private Point2dEpsilonEquals()
    {
    
    }
    
    public static boolean equals(Point2d p1, Point2d p2, double factor)
    {
        double f2 = p1.X() - p2.X();
        
        if(Double.isNaN(f2))
        {
            return false;
        }
        
        double f3 = f2 < 0.0f ? -f2 : f2;
        
        if(f3 > factor)
        {
            return false;
        }
        
        f2 = p1.Y() - p2.Y();
        
        if(Double.isNaN(f2))
        {
            return false;
        }
        
        double f4 = f2 < 0.0f ? -f2 : f2;
        
        return !(f4 > factor);
    }
}