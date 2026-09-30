package br.com.ajf.game.math.library.colors;

import java.awt.Color;

public class Color3f extends ColorRGB<Float>
{
    public Color3f()
    {
        this(0f,0f,0f);
    }
    
    public Color3f(Float r, Float g, Float b)
    {
        super(r,g,b);
    }
    
    public Color3f(IColorRGB<Float> c)
    {
        super(c);
    }
    
    public Color3f(Color c)
    {
        set(c);
    }
    
    public Color3f(Color3f c)
    {
        this(c.red(),c.green(),c.blue());
    }
    
    public void set(Color c)
    {
        setRed((float)c.getRed()/255.0f);
        setGreen((float)c.getGreen()/255.0f);
        setBlue((float)c.getBlue()/255.0f);
    }
    
    public Color get()
    {
        int n = Math.round(red()*255.0f);
        int n2 = Math.round(green()*255.0f);
        int n3 = Math.round(blue()*255.0f);
        return new Color(n,n2,n3);
    }
}