package br.com.ajf.game.math.library.point2;

public final class Point2f extends Point2<Float,Float>
{
    public Point2f()
    {
        this(0.0f,0.0f);
    }
    
    public Point2f(float x,float y)
    {
        this.setX(x);
        this.setY(y);
    }
    
    public Point2f(Float x, Float y)
    {
        super(x,y);
    }
    
    public Point2f(Point2<Float,Float> p)
    {
        super(p);
    }
}