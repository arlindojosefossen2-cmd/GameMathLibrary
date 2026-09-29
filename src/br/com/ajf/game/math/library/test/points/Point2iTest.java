package br.com.ajf.game.math.library.test.points;

import br.com.ajf.game.math.library.point2.Point2i;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Point2iTest
{
    @Test
    public void testPoint2iNotNullWhenCreatedCorrect()
    {
        Point2i p = new Point2i();
        
        Assertions.assertNotNull(p);
        
        p = new Point2i(20,96);
        
        Assertions.assertNotNull(p);
        
        p = new Point2i(new Point2i(45,87));
        
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void testPoint2iValues()
    {
        Point2i p = new Point2i();
        
        Assertions.assertEquals(0,p.x());
        Assertions.assertEquals(0,p.y());
        
        p = new Point2i(20,96);
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        
        p = new Point2i(new Point2i(9,8));
        
        Assertions.assertEquals(9,p.x());
        Assertions.assertEquals(8,p.y());
    }
}