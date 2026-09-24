package br.com.ajf.game.math.library.point2;

public final class Point2d extends Point2<Double,Double>
{
    public Point2d()
    {
        this(0.0,0.0);
    }
    public Point2d(double x,double y)
    {
        this.setX(x);
        this.setY(y);
    }
    public Point2d(Double x,Double y)
    {
        super(x,y);
    }
    
    public Point2d(Point2<Double,Double> p)
    {
        super(p);
    }
}