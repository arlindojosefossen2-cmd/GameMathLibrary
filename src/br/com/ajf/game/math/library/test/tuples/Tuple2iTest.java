package br.com.ajf.game.math.library.test.tuples;

import br.com.ajf.game.math.library.tuples.ITuple2;
import br.com.ajf.game.math.library.tuples.ITuplesUtils;
import br.com.ajf.game.math.library.tuples.Tuple2i;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tuple2iTest
{
    @Test
    public void testTuple2iCorrectCreation()
    {
        ITuple2<Integer> t = new Tuple2i();
        
        Assertions.assertNotNull(t);
        
        t = new Tuple2i(32,76);
        
        Assertions.assertNotNull(t);
        
        t = new Tuple2i(new Integer[]{45,76});
        
        Assertions.assertNotNull(t);
        
        t = new Tuple2i(new Tuple2i(56,997));
        
        Assertions.assertNotNull(t);
    }
    
    @Test
    public void testSaveTuple2iAsObject()
    {
        ITuple2<Integer> t = new Tuple2i(35677,84667);
        Assertions.assertTrue(ITuplesUtils.save(t,"tuple2i.obj"));
    }
    
    @Test
    public void testReadTuple2iAsObject()
    {
        ITuple2<Integer> t = ITuplesUtils.read("tuple2i.obj");
        Assertions.assertNotNull(t);
    }
    
    @Test
    public void testTuple2iCorrectAttribution()
    {
        ITuple2<Integer> t = new Tuple2i();
        
        Assertions.assertEquals(0,t.x());
        Assertions.assertEquals(0,t.y());
        
        t = new Tuple2i(32,768);
        
        Assertions.assertEquals(32,t.x());
        Assertions.assertEquals(768,t.y());
        
        t = new Tuple2i(new Integer[]{45,76});
        
        Assertions.assertEquals(45,t.x());
        Assertions.assertEquals(76,t.y());
        
        t = new Tuple2i(new Tuple2i(56,997));
        
        Assertions.assertEquals(56,t.x());
        Assertions.assertEquals(997,t.y());
    }
    
    @Test
    public void testTuple2iClone()
    {
        ITuple2<Integer> t = new Tuple2i(346,465);
        ITuple2<Integer> clone = t.clone();
        Assertions.assertTrue(clone.equals(t));
    }
    
    @Test
    public void testTuple2iGetWithTuple2i()
    {
        ITuple2<Integer> t = new Tuple2i();
        ITuple2<Integer> get = new Tuple2i();
        t.get(get);
        
        Assertions.assertEquals(0,get.x());
        Assertions.assertEquals(0,get.y());
        
        t = new Tuple2i(32,768);
        t.get(get);
        Assertions.assertEquals(32,get.x());
        Assertions.assertEquals(768,get.y());
        
        t = new Tuple2i(new Integer[]{45,76});
        t.get(get);
        Assertions.assertEquals(45,get.x());
        Assertions.assertEquals(76,get.y());
        
        t = new Tuple2i(new Tuple2i(56,997));
        t.get(get);
        Assertions.assertEquals(56,get.x());
        Assertions.assertEquals(997,get.y());
    }
    
    @Test
    public void testTuple2iGetWithArray()
    {
        ITuple2<Integer> t = new Tuple2i();
        Integer[] get = new Integer[2];
        t.get(get);
        
        Assertions.assertEquals(0,get[0]);
        Assertions.assertEquals(0,get[1]);
        
        t = new Tuple2i(32,768);
        t.get(get);
        Assertions.assertEquals(32,get[0]);
        Assertions.assertEquals(768,get[1]);
        
        t = new Tuple2i(new Integer[]{45,76});
        t.get(get);
        Assertions.assertEquals(45,get[0]);
        Assertions.assertEquals(76,get[1]);
        
        t = new Tuple2i(new Tuple2i(56,997));
        t.get(get);
        Assertions.assertEquals(56,get[0]);
        Assertions.assertEquals(997,get[1]);
    }
}