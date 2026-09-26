package br.com.ajf.game.math.library.test;

import br.com.ajf.game.math.library.point2.Point2f;
import br.com.ajf.game.math.library.vector2.Vector2f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Vector2fTest
{
    @Test
    public void testVector2fNotNullWhenCreatedCorrect()
    {
        Vector2f v = new Vector2f();
        
        Assertions.assertNotNull(v);
        
        v = new Vector2f(20.34f,96.94f);
        
        Assertions.assertNotNull(v);
        
        v = new Vector2f(new float[]{9.8f,8.56f});
        
        Assertions.assertNotNull(v);
        
        v = new Vector2f(new Point2f(34.4f,45.6f));
        
        Assertions.assertNotNull(v);
        
        v = new Vector2f(new Vector2f(67.56f,999.56f));
        
        Assertions.assertNotNull(v);
    }
    
    @Test
    public void testVector2fValues()
    {
        Vector2f v = new Vector2f();
        
        Assertions.assertEquals(0f,v.x());
        Assertions.assertEquals(0f,v.y());
        
        v = new Vector2f(20.34f,96.94f);
        
        Assertions.assertEquals(20.34f,v.x());
        Assertions.assertEquals(96.94f,v.y());
        
        v = new Vector2f(new float[]{9.8f,8.56f});
        
        Assertions.assertEquals(9.8f,v.x());
        Assertions.assertEquals(8.56f,v.y());
        
        v = new Vector2f(new Point2f(34.4f,45.6f));
        
        Assertions.assertEquals(34.4f,v.x());
        Assertions.assertEquals(45.6f,v.y());
        
        v = new Vector2f(new Vector2f(67.56f,999.56f));
        
        Assertions.assertEquals(67.56f,v.x());
        Assertions.assertEquals(999.56f,v.y());
    }
}