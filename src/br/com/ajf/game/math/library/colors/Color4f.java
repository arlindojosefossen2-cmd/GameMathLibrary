package br.com.ajf.game.math.library.colors;

import java.awt.*;

public class Color4f extends ColorRGBA<Float>
{
    public Color4f()
    {
        this( 0f,  0f, 0f, 0f);
    }
    
    public Color4f(Float r, Float g, Float b, Float a)
    {
        super(r, g, b, a);
    }
    
    public Color4f(Color4f c)
    {
        set(c);
    }
    
    public Color4f(IColor<Float> c)
    {
        super(c);
    }
    
    public Color4f(Color c)
    {
        set(c);
    }
    
    public void set(Color c)
    {
        setRed((float) c.getRed()/255.0f);
        setGreen((float) c.getGreen()/255.0f);
        setBlue((float) c.getBlue()/255.0f);
        setAlpha((float) c.getAlpha()/255.0f);
    }
    
    public Color get()
    {
        int n = Math.round(red()*255.0f);
        int n2 = Math.round(green()*255.0f);
        int n3 = Math.round(blue()*255.0f);
        int n4 = Math.round(alpha()*255.0f);
        return new Color(n,n2,n3,n4);
    }
}