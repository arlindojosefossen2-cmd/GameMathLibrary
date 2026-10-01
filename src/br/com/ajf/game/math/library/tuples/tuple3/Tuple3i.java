package br.com.ajf.game.math.library.tuples.tuple3;

public final class Tuple3i extends Tuple3<Integer>
{
    public Tuple3i()
    {
        this(0,0,0);
    }
    
    public Tuple3i(Integer integer, Integer y, Integer z)
    {
        super(integer, y, z);
    }
    
    public Tuple3i(ITuple3<Integer> t)
    {
        super(t);
    }
    
    public Tuple3i(Integer[] array)
    {
        super(array);
    }
}