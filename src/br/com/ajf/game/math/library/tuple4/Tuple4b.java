package br.com.ajf.game.math.library.tuple4;

public class Tuple4b extends Tuple4<Byte>
{
    public Tuple4b()
    {
        this((byte) 0, (byte) 0, (byte) 0, (byte) 0);
    }
    
    public Tuple4b(Byte r, Byte g, Byte b, Byte a)
    {
        super(r, g, b, a);
    }
    
    public Tuple4b(Byte[] array)
    {
        super(array);
    }
    
    public Tuple4b(ITuple4<Byte> t)
    {
        super(t);
    }
}