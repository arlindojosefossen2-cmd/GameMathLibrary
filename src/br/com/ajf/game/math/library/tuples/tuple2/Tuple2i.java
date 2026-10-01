package br.com.ajf.game.math.library.tuples.tuple2;

public final class Tuple2i extends Tuple2<Integer>
{
    public Tuple2i()
    {
        this(0,0);
    }
    
    public Tuple2i(Integer integer, Integer y)
    {
        super(integer, y);
    }
    
    public Tuple2i(ITuple2<Integer> t)
    {
        super(t);
    }
    
    public Tuple2i(Integer[] array)
    {
        super(array);
    }
}