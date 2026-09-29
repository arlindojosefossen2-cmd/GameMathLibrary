package br.com.ajf.game.math.library.test.points;

import br.com.ajf.game.math.library.point2.Point2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Point2dTest
{
    @Test
    public void testPoint2dNotNullWhenCreatedCorrect()
    {
        Point2d p = new Point2d();
        
        Assertions.assertNotNull(p);
        
        p = new Point2d(20,96);
        
        Assertions.assertNotNull(p);
        
        p = new Point2d(new Point2d(45,87));
        
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void testPoint2dValues()
    {
        Point2d p = new Point2d();
        
        Assertions.assertEquals(0.0,p.x());
        Assertions.assertEquals(0.0,p.y());
        
        p = new Point2d(20,96.47);
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96.47,p.y());
        
        p = new Point2d(new Point2d(9.23,8));
        
        Assertions.assertEquals(9.23,p.x());
        Assertions.assertEquals(8,p.y());
    }
}