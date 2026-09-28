package br.com.ajf.game.math.library.tuple4;

public class Tuple4f extends Tuple4<Float>
{
    public Tuple4f()
    {
        this(0f,0f,0f,0f);
    }
    
    public Tuple4f(Float r, Float g, Float b, Float a)
    {
        super(r, g, b, a);
    }
    
    public Tuple4f(Float[] array)
    {
        super(array);
    }
    
    public Tuple4f(ITuple4<Float> t)
    {
        super(t);
    }
}