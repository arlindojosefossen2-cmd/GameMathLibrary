package br.com.ajf.game.math.library.point2;

public final class Point2d extends Point2<Double,Double>
{
    public Point2d()
    {
        this(0.0,0.0);
    }
    public Point2d(double x,double y)
    {
       super(x,y);
    }
    public Point2d(Double x,Double y)
    {
        super(x,y);
    }
    
    public Point2d(Point2<Double,Double> p)
    {
        super(p);
    }
    
    @Override
    public void clamp(Double n1, Double n2)
    {
        if(this.x() > n2)
        {
            setX(n2);
        }
        else if(x() < n1)
        {
            setX(n1);
        }
        
        if(y() > n2)
        {
            setY(n2);
        }
        else if(y() < n1)
        {
            setY(n1);
        }
    }
    
    @Override
    public void negate()
    {
        setX(-x());
        setY(-y());
    }
    
    @Override
    public void negate(Point2<Double, Double> p)
    {
        setX(-p.x());
        setY(-p.y());
    }
    
    @Override
    public void add(Point2<Double, Double> p)
    {
        setX(x()+p.x());
        setY(y()+p.y());
    }
    
    @Override
    public void sub(Point2<Double, Double> p)
    {
        setX(x()-p.x());
        setY(y()-p.y());
    }
    
    @Override
    public void multiply(Point2<Double, Double> p)
    {
        setX(x()*p.x());
        setY(y()*p.y());
    }
    
    @Override
    public void divide(Point2<Double, Double> p)
    {
        if(p.x() == 0.0 || p.y() == 0.0)
        {
            return;
        }
        setX(x()/p.x());
        setY(y()/p.y());
    }
}