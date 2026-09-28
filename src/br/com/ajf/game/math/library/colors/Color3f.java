package br.com.ajf.game.math.library.colors;

import br.com.ajf.game.math.library.tuples.ITuple3;
import br.com.ajf.game.math.library.tuples.Tuple3;

import java.awt.*;

public class Color3f extends Tuple3<Float>
{
    public Color3f()
    {
        this(0f,0f,0f);
    }
    
    public Color3f(Float x, Float y, Float z)
    {
        super(x, y, z);
    }
    
    public Color3f(ITuple3<Float> t)
    {
        super(t);
    }
    
    public Color3f(Color c)
    {
        set(c);
    }
    
    public Color3f(Color3f c)
    {
        this(c.r(),c.g(),c.b());
    }
    
    public Color3f(Float[] array)
    {
        super(array);
    }
    
    public void set(Color c)
    {
        setR((float)c.getRed()/255.0f);
        setG((float)c.getGreen()/255.0f);
        setB((float)c.getBlue()/255.0f);
    }
    
    public Color get()
    {
        int n = Math.round(r()*255.0f);
        int n2 = Math.round(g()*255.0f);
        int n3 = Math.round(b()*255.0f);
        return new Color(n,n2,n3);
    }
}