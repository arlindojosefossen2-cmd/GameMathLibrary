package br.com.ajf.game.math.library.test.points;

import br.com.ajf.game.math.library.point2.Point2f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Point2fTest
{
    @Test
    public void testPoint2fNotNullWhenCreatedCorrect()
    {
        Point2f p = new Point2f();
        
        Assertions.assertNotNull(p);
        
        p = new Point2f(20f,96f);
        
        Assertions.assertNotNull(p);
        
        p = new Point2f(new Point2f(45.8f,87.9f));
        
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void testPoint2fValues()
    {
        Point2f p = new Point2f();
        
        Assertions.assertEquals(0f,p.x());
        Assertions.assertEquals(0f,p.y());
        
        p = new Point2f(20.9f,96f);
        
        Assertions.assertEquals(20.9f,p.x());
        Assertions.assertEquals(96,p.y());
        
        p = new Point2f(new Point2f(9.9f,8.7f));
        
        Assertions.assertEquals(9.9f,p.x());
        Assertions.assertEquals(8.7f,p.y());
    }
}