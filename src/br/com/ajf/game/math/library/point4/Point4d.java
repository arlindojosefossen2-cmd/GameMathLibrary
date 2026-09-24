package br.com.ajf.game.math.library.point4;

public class Point4d extends Point4<Double,Double,Double,Double>
{
    public Point4d()
    {
        this(0.0,0.0,0.0,0.0);
    }
    
    public Point4d(double x, double y, double z, double w)
    {
        super(x,y,z,w);
    }
    
    public Point4d(Double x, Double y, Double z, Double w)
    {
        super(x,y,z,w);
    }
    
    public Point4d(Point4<Double, Double, Double, Double> p)
    {
        super(p);
    }
}
