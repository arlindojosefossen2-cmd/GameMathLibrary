package br.com.ajf.game.math.library.test;

import br.com.ajf.game.math.library.vector2.Vector2f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class Vector2fTest
{
    @Test
    public void testVector2f()
    {
        Vector2f v = new Vector2f();
        
        Assertions.assertNotNull(v);
        
        Assertions.assertEquals(0,v.x());
        Assertions.assertEquals(0,v.y());
    }
}
