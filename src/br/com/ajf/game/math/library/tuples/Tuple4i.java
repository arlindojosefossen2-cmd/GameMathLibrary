package br.com.ajf.game.math.library.tuples;

public final class Tuple4i extends Tuple4<Integer>
{
    public Tuple4i()
    {
        this(0,0,0,0);
    }
    
    public Tuple4i(Integer integer, Integer y, Integer z, Integer w)
    {
        super(integer, y, z, w);
    }
    
    public Tuple4i(Integer[] array)
    {
        super(array);
    }
    
    public Tuple4i(ITuple4<Integer> t)
    {
        super(t);
    }
}