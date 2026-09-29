package br.com.ajf.game.math.library.test.points;

import br.com.ajf.game.math.library.point3.Point3i;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Point3iTest
{
    @Test
    public void testPoint3iNotNullWhenCreatedCorrect()
    {
        Point3i p = new Point3i();
        
        Assertions.assertNotNull(p);
        
        p = new Point3i(20,96,120);
        
        Assertions.assertNotNull(p);
        
        p = new Point3i(new int[]{20,96,120});
        
        Assertions.assertNotNull(p);
        
        p = new Point3i(new Point3i(45,87,230));
        
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void testPoint3iValues()
    {
        Point3i p = new Point3i();
        
        Assertions.assertEquals(0,p.x());
        Assertions.assertEquals(0,p.y());
        Assertions.assertEquals(0,p.z());
        
        p = new Point3i(20,96,120);
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        Assertions.assertEquals(120,p.z());
        
        p = new Point3i(new int[]{20,96,120});
        
        Assertions.assertEquals(20,p.x());
        Assertions.assertEquals(96,p.y());
        Assertions.assertEquals(120,p.z());
        
        p = new Point3i(new Point3i(45,87,230));
        
        Assertions.assertEquals(45,p.x());
        Assertions.assertEquals(87,p.y());
        Assertions.assertEquals(230,p.z());
    }
}