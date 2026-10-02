package br.com.ajf.game.math.library.test.tuples;

import br.com.ajf.game.math.library.tuples.*;
import br.com.ajf.game.math.library.tuples.tuple3.ITuple3;
import br.com.ajf.game.math.library.tuples.tuple3.Tuple3i;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tuple3iTest
{
    @Test
    public void testSaveTuple3iAsObject()
    {
        ITuple3<Integer> t = new Tuple3i(35677,84667,3566);
        Assertions.assertTrue(new ITuplesUtils().save(t,"tuple3i.obj"));
    }
    
    @Test
    public void testReadTuple3iAsObject()
    {
        ITuple3<Integer> t = new ITuplesUtils().read("tuple3i.obj");
        Assertions.assertNotNull(t);
    }
    @Test
    public void testTuple3iCorrectCreation()
    {
        ITuple3<Integer> t = new Tuple3i();
        
        Assertions.assertNotNull(t);
        
        t = new Tuple3i(32,76,123);
        
        Assertions.assertNotNull(t);
        
        t = new Tuple3i(new Integer[]{45, 76,45});
        
        Assertions.assertNotNull(t);
        
        t = new Tuple3i(new Tuple3i(56,997,45));
        
        Assertions.assertNotNull(t);
    }
    @Test
    public void testTuple3iCorrectAttribution()
    {
        ITuple3<Integer> t = new Tuple3i();
        
        Assertions.assertEquals(0,t.x());
        Assertions.assertEquals(0,t.y());
        Assertions.assertEquals(0,t.y());
        
        t = new Tuple3i(32,768,67);
        
        Assertions.assertEquals(32,t.x());
        Assertions.assertEquals(768,t.y());
        Assertions.assertEquals(67,t.z());
        
        t = new Tuple3i(new Integer[]{45,76,23});
        
        Assertions.assertEquals(45,t.x());
        Assertions.assertEquals(76,t.y());
        Assertions.assertEquals(23,t.z());
        
        t = new Tuple3i(new Tuple3i(56,997,45));
        
        Assertions.assertEquals(56,t.x());
        Assertions.assertEquals(997,t.y());
        Assertions.assertEquals(45,t.z());
    }
    
    @Test
    public void testTuple3iGetWithTuple3i()
    {
        ITuple3<Integer> t = new Tuple3i();
        ITuple3<Integer> get = new Tuple3i();
        t.get(get);
        Assertions.assertEquals(0,get.x());
        Assertions.assertEquals(0,get.y());
        Assertions.assertEquals(0,get.y());
        
        t = new Tuple3i(32,768,67);
        t.get(get);
        Assertions.assertEquals(32,get.x());
        Assertions.assertEquals(768,get.y());
        Assertions.assertEquals(67,get.z());
        
        t = new Tuple3i(new Integer[]{45,76,23});
        t.get(get);
        Assertions.assertEquals(45,get.x());
        Assertions.assertEquals(76,get.y());
        Assertions.assertEquals(23,get.z());
        
        t = new Tuple3i(new Tuple3i(56,997,45));
        t.get(get);
        Assertions.assertEquals(56,get.x());
        Assertions.assertEquals(997,get.y());
        Assertions.assertEquals(45,get.z());
    }
    @Test
    public void testTuple3iGetWithArray()
    {
        ITuple3<Integer> t = new Tuple3i();
        Integer[] get = new Integer[3];
        t.get(get);
        Assertions.assertEquals(0,get[0]);
        Assertions.assertEquals(0,get[1]);
        Assertions.assertEquals(0,get[2]);
        
        t = new Tuple3i(32,768,67);
        t.get(get);
        Assertions.assertEquals(32,get[0]);
        Assertions.assertEquals(768,get[1]);
        Assertions.assertEquals(67,get[2]);
        
        t = new Tuple3i(new Integer[]{45,76,23});
        t.get(get);
        Assertions.assertEquals(45,get[0]);
        Assertions.assertEquals(76,get[1]);
        Assertions.assertEquals(23,get[2]);
        
        t = new Tuple3i(new Tuple3i(56,997,45));
        t.get(get);
        Assertions.assertEquals(56,get[0]);
        Assertions.assertEquals(997,get[1]);
        Assertions.assertEquals(45,get[2]);
    }
    
    @Test
    public void testTuple3iClone()
    {
        ITuple3<Integer> t = new Tuple3i(346,465,5767);
        ITuple3<Integer> clone = t.clone();
        Assertions.assertTrue(clone.equals(t));
    }
}