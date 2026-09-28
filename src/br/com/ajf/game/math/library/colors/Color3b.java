package br.com.ajf.game.math.library.colors;

import br.com.ajf.game.math.library.tuple3.ITuple3;
import br.com.ajf.game.math.library.tuple3.Tuple3b;

import java.awt.*;

public class Color3b extends Tuple3b
{
    public Color3b()
    {
    }
    
    public Color3b(Byte aByte, Byte y, Byte z)
    {
        super(aByte, y, z);
    }
    
    public Color3b(ITuple3<Byte> t)
    {
        super(t);
    }
    
    public Color3b(Color c)
    {
       set(c);
    }
    
    public Color3b(Color3b c)
    {
        this(c.r(),c.g(),c.b());
    }
    
    public Color3b(Byte[] array)
    {
        super(array);
    }
    
    public void set(Color c)
    {
        setR((byte) c.getRed());
        setG((byte) c.getGreen());
        setB((byte) c.getBlue());
    }
    
    public Color get()
    {
        int n = r() & 0xFF;
        int n2 = g() & 0xFF;
        int n3 = b() & 0xFF;
        return new Color(n,n2,n3);
    }
}