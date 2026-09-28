package br.com.ajf.game.math.library.tuple3;

public class Tuple3f extends Tuple3<Float>
{
    public Tuple3f()
    {
        this(0f, 0f, 0f);
    }
    
    public Tuple3f(Float x, Float y, Float z)
    {
        super(x, y, z);
    }
    
    public Tuple3f(ITuple3<Float> t)
    {
        super(t);
    }
    
    public Tuple3f(Float[] array)
    {
        super(array);
    }
}