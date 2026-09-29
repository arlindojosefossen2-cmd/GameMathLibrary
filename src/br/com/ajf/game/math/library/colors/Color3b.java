package br.com.ajf.game.math.library.colors;

import java.awt.*;

public class Color3b extends ColorRGB<Byte>
{
    public Color3b()
    {
        this((byte) 0, (byte) 0, (byte) 0);
    }
    
    public Color3b(Byte r, Byte g, Byte b)
    {
        super(r,g,b);
    }
    
    public Color3b(IColor<Byte> t)
    {
        super(t);
    }
    
    public Color3b(Color c)
    {
       set(c);
    }
    
    public Color3b(Color3b c)
    {
        this(c.red(),c.green(),c.blue());
    }
    
    
    public void set(Color c)
    {
        setRed((byte) c.getRed());
        setGreen((byte) c.getGreen());
        setBlue((byte) c.getBlue());
    }
    
    public Color get()
    {
        int n = red() & 0xFF;
        int n2 = green() & 0xFF;
        int n3 = blue() & 0xFF;
        int n4 = 255;
        return new Color(n,n2,n3,n4);
    }
    
    @Override
    public Byte alpha()
    {
        return (byte)255.0;
    }
    
    @Override
    public void setAlpha(Byte a)
    {
        a = (byte)255.0;
        super.setAlpha(a);
    }
}