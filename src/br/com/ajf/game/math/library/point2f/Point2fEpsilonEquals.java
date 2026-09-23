package br.com.ajf.game.math.library.point2f;

public final class Point2fEpsilonEquals
{
    private Point2fEpsilonEquals()
    {
    
    }
    
    public static boolean equals(Point2f p1, Point2f p2, float factor)
    {
        float f2 = p1.X() - p2.X();
        
        if(Float.isNaN(f2))
        {
            return false;
        }
        
        float f3 = f2 < 0.0f ? -f2 : f2;
        
        if(f3 > factor)
        {
            return false;
        }
        
        f2 = p1.Y() - p2.Y();
        
        if(Float.isNaN(f2))
        {
            return false;
        }
        
        float f4 = f2 < 0.0f ? -f2 : f2;
        
        return !(f4 > factor);
    }
}