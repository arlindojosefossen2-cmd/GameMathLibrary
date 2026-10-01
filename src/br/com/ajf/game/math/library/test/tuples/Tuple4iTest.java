package br.com.ajf.game.math.library.test.tuples;

import br.com.ajf.game.math.library.tuples.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tuple4iTest
{
    @Test
    public void testSaveTuple3iAsObject()
    {
        ITuple4<Integer> t = new Tuple4i(35677,84667,3566,4677);
        ITuplesUtils.save(t,"tuple4i.obj");
    }
    
    @Test
    public void testReadTuple3iAsObject()
    {
        ITuple3<Integer> t = ITuplesUtils.read("tuple4i.obj");
    }
    
    @Test
    public void testTuple4iCorrectCreation()
    {
        ITuple4<Integer> t = new Tuple4i();
        
        Assertions.assertNotNull(t);
        
        t = new Tuple4i(32,76,123,234);
        
        Assertions.assertNotNull(t);
        
        t = new Tuple4i(new Integer[]{45, 76,45,56777});
        
        Assertions.assertNotNull(t);
        
        t = new Tuple4i(new Tuple4i(56,997,45,4677));
        
        Assertions.assertNotNull(t);
    }
    
    @Test
    public void testTuple4iClone()
    {
        ITuple4<Integer> t = new Tuple4i(346,465,5767,3556);
        ITuple4<Integer> clone = t.clone();
        Assertions.assertTrue(clone.equals(t));
    }
    
    @Test
    public void testTuple4iCorrectAttribution()
    {
        ITuple4<Integer> t = new Tuple4i();
        
        Assertions.assertEquals(0,t.x());
        Assertions.assertEquals(0,t.y());
        Assertions.assertEquals(0,t.z());
        Assertions.assertEquals(0,t.w());
        
        t = new Tuple4i(32,768,67,45);
        
        Assertions.assertEquals(32,t.x());
        Assertions.assertEquals(768,t.y());
        Assertions.assertEquals(67,t.z());
        Assertions.assertEquals(45,t.w());
        
        t = new Tuple4i(new Integer[]{45,76,23,56});
        
        Assertions.assertEquals(45,t.x());
        Assertions.assertEquals(76,t.y());
        Assertions.assertEquals(23,t.z());
        Assertions.assertEquals(56,t.w());
        
        t = new Tuple4i(new Tuple4i(23,56,997,45));
        
        Assertions.assertEquals(23,t.x());
        Assertions.assertEquals(56,t.y());
        Assertions.assertEquals(997,t.z());
        Assertions.assertEquals(45,t.w());
    }
    @Test
    public void testTuple4iGetWithTuple4i()
    {
        ITuple4<Integer> t = new Tuple4i();
        ITuple4<Integer> get = new Tuple4i();
        t.get(get);
        Assertions.assertEquals(0,get.x());
        Assertions.assertEquals(0,get.y());
        Assertions.assertEquals(0,get.z());
        Assertions.assertEquals(0,get.w());
        
        t = new Tuple4i(32,768,67,45);
        t.get(get);
        Assertions.assertEquals(32,get.x());
        Assertions.assertEquals(768,get.y());
        Assertions.assertEquals(67,get.z());
        Assertions.assertEquals(45,get.w());
        
        t = new Tuple4i(new Integer[]{45,76,23,56});
        t.get(get);
        Assertions.assertEquals(45,get.x());
        Assertions.assertEquals(76,get.y());
        Assertions.assertEquals(23,get.z());
        Assertions.assertEquals(56,get.w());
        
        t = new Tuple4i(new Tuple4i(23,56,997,45));
        t.get(get);
        Assertions.assertEquals(23,get.x());
        Assertions.assertEquals(56,get.y());
        Assertions.assertEquals(997,get.z());
        Assertions.assertEquals(45,get.w());
    }
    
    @Test
    public void testTuple4iGetWithArray()
    {
        ITuple4<Integer> t = new Tuple4i();
        Integer[] get = new Integer[4];
        t.get(get);
        Assertions.assertEquals(0,get[0]);
        Assertions.assertEquals(0,get[1]);
        Assertions.assertEquals(0,get[2]);
        Assertions.assertEquals(0,get[3]);
        
        t = new Tuple4i(32,768,67,45);
        t.get(get);
        Assertions.assertEquals(32,get[0]);
        Assertions.assertEquals(768,get[1]);
        Assertions.assertEquals(67,get[2]);
        Assertions.assertEquals(45,get[3]);
        
        t = new Tuple4i(new Integer[]{45,76,23,56});
        t.get(get);
        Assertions.assertEquals(45,get[0]);
        Assertions.assertEquals(76,get[1]);
        Assertions.assertEquals(23,get[2]);
        Assertions.assertEquals(56,get[3]);
        
        t = new Tuple4i(new Tuple4i(23,56,997,45));
        t.get(get);
        Assertions.assertEquals(23,get[0]);
        Assertions.assertEquals(56,get[1]);
        Assertions.assertEquals(997,get[2]);
        Assertions.assertEquals(45,get[3]);
    }
}