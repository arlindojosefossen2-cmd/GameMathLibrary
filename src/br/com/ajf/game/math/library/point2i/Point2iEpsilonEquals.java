package br.com.ajf.game.math.library.point2i;

import br.com.ajf.game.math.library.point2f.Point2f;

public class Point2iEpsilonEquals
{
    private Point2iEpsilonEquals()
    {
    
    }
    
    public static boolean equals(Point2i p1, Point2i p2, int factor)
    {
        float f2 = p1.X() - p2.X();
        
        float f3 = f2 < 0.0f ? -f2 : f2;
        
        if(f3 > factor)
        {
            return false;
        }
        
        f2 = p1.Y() - p2.Y();
        
        float f4 = f2 < 0.0f ? -f2 : f2;
        
        return !(f4 > factor);
    }
}