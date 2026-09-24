package br.com.ajf.game.math.library.point3;

public class Point3d extends Point3<Double,Double,Double>
{
    public Point3d()
    {
        this(0.0,0.0,0.0);
    }
    
    public Point3d(double x, double y, double z)
    {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
    
    public Point3d(Double x, Double y, Double z)
    {
        super(x, y, z);
    }
    
    public Point3d(Point3<Double,Double,Double> p)
    {
        super(p);
    }
}