package br.com.ajf.game.math.library.colors;

import br.com.ajf.game.math.library.tuple4.ITuple4;
import br.com.ajf.game.math.library.tuple4.Tuple4f;

import java.awt.*;

public class Color4f extends Tuple4f
{
    public Color4f()
    {
        this( 0f,  0f, 0f, 0f);
    }
    
    public Color4f(Float r, Float g, Float b, Float a)
    {
        super(r, g, b, a);
    }
    
    public Color4f(Float[] array)
    {
        super(array);
    }
    
    public Color4f(Color4f c)
    {
        set(c);
    }
    
    public Color4f(ITuple4<Float> t)
    {
        super(t);
    }
    
    public Color4f(Color c)
    {
        set(c);
    }
    
    public void set(Color c)
    {
        setR((float) c.getRed()/255.0f);
        setG((float) c.getGreen()/255.0f);
        setB((float) c.getBlue()/255.0f);
        setA((float) c.getAlpha()/255.0f);
    }
    
    public Color get()
    {
        int n = Math.round(r()*255.0f);
        int n2 = Math.round(g()*255.0f);
        int n3 = Math.round(b()*255.0f);
        int n4 = Math.round(a()*255.0f);
        return new Color(n,n2,n3,n4);
    }
}