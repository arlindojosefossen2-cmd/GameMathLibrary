package br.com.ajf.game.math.library.test.points;

import br.com.ajf.game.math.library.point4.Point4f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Point4fTest
{
    @Test
    public void testPoint4fNotNullWhenCreatedCorrect()
    {
        Point4f p = new Point4f();
        
        Assertions.assertNotNull(p);
        
        p = new Point4f(20,96,120,235);
        
        Assertions.assertNotNull(p);
        
        p = new Point4f(new float[]{20,96,120,34});
        
        Assertions.assertNotNull(p);
        
        p = new Point4f(new Point4f(45,87,230,450));
        
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void testPoint4fValues()
    {
        Point4f p = new Point4f();
        
        Assertions.assertEquals(0,p.x());
        Assertions.assertEquals(0,p.y());
        Assertions.assertEquals(0,p.z());
        Assertions.assertEquals(0,p.w());
        
        p = new Point4f(20,96,120,345);
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        Assertions.assertEquals(120,p.z());
        Assertions.assertEquals(345,p.w());
        
        p = new Point4f(new float[]{20,96,120,231});
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        Assertions.assertEquals(120,p.z());
        Assertions.assertEquals(231,p.w());
        
        p = new Point4f(new Point4f(45,87,230,785));
        
        Assertions.assertEquals(45,p.x());
        Assertions.assertEquals(87,p.y());
        Assertions.assertEquals(230,p.z());
        Assertions.assertEquals(785,p.w());
    }
}