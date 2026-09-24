package br.com.ajf.game.math.library.point3;

public class Point3f extends Point3<Float,Float,Float>
{
    public Point3f()
    {
        this(0f,0f,0f);
    }
    
    public Point3f(float x, float y, float z)
    {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
    
    public Point3f(Float x, Float y, Float z)
    {
        super(x, y, z);
    }
    
    public Point3f(Point3<Float,Float,Float> p)
    {
        super(p);
    }
}