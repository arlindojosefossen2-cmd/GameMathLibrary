package br.com.ajf.game.math.library.colors;

import java.awt.*;

public class Color4b extends ColorRGBA<Byte>
{
    public Color4b()
    {
        this((byte) 0, (byte) 0, (byte) 0, (byte) 0);
    }
    
    public Color4b(Byte r, Byte g, Byte b, Byte a)
    {
        super(r, g, b, a);
    }
    
    public Color4b(ColorRGBA<Byte> c)
    {
        super(c);
    }
    
    public Color4b(IColorRGB<Byte> c)
    {
        super(c);
    }
    
    public Color4b(Color4b c)
    {
        set(c);
    }
    
    public Color4b(Color c)
    {
        super((byte) c.getRed(), (byte) c.getGreen(), (byte) c.getBlue(), (byte) c.getAlpha());
    }
    
    public void set(Color c)
    {
        setRed((byte) c.getRed());
        setGreen((byte) c.getGreen());
        setBlue((byte) c.getBlue());
        setAlpha((byte) c.getAlpha());
    }
    
    public Color get()
    {
        int n = red() & 0xFF;
        int n2 = green() & 0xFF;
        int n3 = blue() & 0xFF;
        int n4 = alpha() & 0xFF;
        return new Color(n,n2,n3,n4);
    }
}