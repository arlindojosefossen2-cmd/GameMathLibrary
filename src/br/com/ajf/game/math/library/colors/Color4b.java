package br.com.ajf.game.math.library.colors;

import br.com.ajf.game.math.library.tuples.ITuple4;
import br.com.ajf.game.math.library.tuples.Tuple4;

import java.awt.*;

public class Color4b extends Tuple4<Byte>
{
    public Color4b()
    {
        this((byte) 0, (byte) 0, (byte) 0, (byte) 0);
    }
    
    public Color4b(Byte r, Byte g, Byte b, Byte a)
    {
        super(r, g, b, a);
    }
    
    public Color4b(Byte[] array)
    {
        super(array);
    }
    
    public Color4b(Color4b c)
    {
        set(c);
    }
    
    public Color4b(ITuple4<Byte> t)
    {
        super(t);
    }
    
    public Color4b(Color c)
    {
        super((byte) c.getRed(), (byte) c.getGreen(), (byte) c.getBlue(), (byte) c.getAlpha());
    }
    
    public void set(Color c)
    {
        setR((byte) c.getRed());
        setG((byte) c.getGreen());
        setB((byte) c.getBlue());
        setA((byte) c.getAlpha());
    }
    
    public Color get()
    {
        int n = r() & 0xFF;
        int n2 = g() & 0xFF;
        int n3 = b() & 0xFF;
        int n4 = a() & 0xFF;
        return new Color(n,n2,n3,n4);
    }
}