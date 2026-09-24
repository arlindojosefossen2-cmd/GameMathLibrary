package br.com.ajf.game.math.library.point4;

public class Point4f extends Point4<Float,Float,Float,Float>
{
    public Point4f()
    {
        this(0f,0f,0f,0f);
    }
    
    public Point4f(float x, float y, float z, float w)
    {
        super(x,y,z,w);
    }
    
    public Point4f(Float x, Float y, Float z, Float w)
    {
        super(x, y, z, w);
    }
    
    public Point4f(Point4<Float, Float, Float, Float> p)
    {
        super(p);
    }
}
