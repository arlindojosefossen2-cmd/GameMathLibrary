package br.com.ajf.game.math.library.test.vectors;

import br.com.ajf.game.math.library.point2.Point2d;
import br.com.ajf.game.math.library.vector2.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Vector2dTest
{
    @Test
    public void testVector2dNotNullWhenCreatedCorrect()
    {
        Vector2d v = new Vector2d();
        
        Assertions.assertNotNull(v);
        
        v = new Vector2d(20.34,96.94);
        
        Assertions.assertNotNull(v);
        
        v = new Vector2d(new double[]{9.8,8.56});
        
        Assertions.assertNotNull(v);
        
        v = new Vector2d(new Point2d(34.4,45.6));
        
        Assertions.assertNotNull(v);
        
        v = new Vector2d(new Vector2d(67.56,999.56));
        
        Assertions.assertNotNull(v);
    }
    
    @Test
    public void testVector2dValues()
    {
        Vector2d v = new Vector2d();
        
        Assertions.assertEquals(0.0,v.x());
        Assertions.assertEquals(0.0,v.y());
        
        v = new Vector2d(20.34,96.94);
        
        Assertions.assertEquals(20.34,v.x());
        Assertions.assertEquals(96.94,v.y());
        
        v = new Vector2d(new double[]{9.8,8.56});
        
        Assertions.assertEquals(9.8,v.x());
        Assertions.assertEquals(8.56,v.y());
        
        v = new Vector2d(new Point2d(34.4,45.6));
        
        Assertions.assertEquals(34.4,v.x());
        Assertions.assertEquals(45.6,v.y());
        
        v = new Vector2d(new Vector2d(67.56,999.56));
        
        Assertions.assertEquals(67.56,v.x());
        Assertions.assertEquals(999.56,v.y());
    }
}