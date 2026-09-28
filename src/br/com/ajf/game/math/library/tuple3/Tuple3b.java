package br.com.ajf.game.math.library.tuple3;

public class Tuple3b extends Tuple3<Byte>
{
    public Tuple3b()
    {
        this((byte) 0, (byte) 0, (byte) 0);
    }
    
    public Tuple3b(Byte aByte, Byte y, Byte z)
    {
        super(aByte, y, z);
    }
    
    public Tuple3b(ITuple3<Byte> t)
    {
        super(t);
    }
    
    public Tuple3b(Byte[] array)
    {
        super(array);
    }
}