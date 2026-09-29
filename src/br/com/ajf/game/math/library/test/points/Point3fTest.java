package br.com.ajf.game.math.library.test.points;

import br.com.ajf.game.math.library.point3.Point3f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Point3fTest
{
    @Test
    public void testPoint3fNotNullWhenCreatedCorrect()
    {
        Point3f p = new Point3f();
        
        Assertions.assertNotNull(p);
        
        p = new Point3f(20,96,120);
        
        Assertions.assertNotNull(p);
        
        p = new Point3f(new float[]{20,96,120});
        
        Assertions.assertNotNull(p);
        
        p = new Point3f(new Point3f(45,87,230));
        
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void testPoint3fValues()
    {
        Point3f p = new Point3f();
        
        Assertions.assertEquals(0,p.x());
        Assertions.assertEquals(0,p.y());
        Assertions.assertEquals(0,p.z());
        
        p = new Point3f(20,96,120);
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        Assertions.assertEquals(120,p.z());
        
        p = new Point3f(new float[]{20,96,120});
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        Assertions.assertEquals(120,p.z());
        
        p = new Point3f(new Point3f(45,87,230));
        
        Assertions.assertEquals(45,p.x());
        Assertions.assertEquals(87,p.y());
        Assertions.assertEquals(230,p.z());
    }
}