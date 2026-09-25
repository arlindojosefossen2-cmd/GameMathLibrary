package br.com.ajf.game.math.library.vector2;

import br.com.ajf.game.math.library.point2.Point2;
import br.com.ajf.game.math.library.point2.Point2d;

public final class Vector2d extends Point2d
{
    public Vector2d()
    {
        this(0,0);
    }
    
    public Vector2d(double x, double y)
    {
        super(x, y);
    }
    
    public Vector2d(Point2<Double,Double> p)
    {
        super(p);
    }
    
    public Vector2d(double[] arrayPoints)
    {
        if(arrayPoints.length < 2)
        {
            return;
        }
        
        set(arrayPoints[0],arrayPoints[1]);
    }
    
    public Vector2d(Vector2d v)
    {
        this(v.x(),v.y());
    }
    
    public Double lengthSquared()
    {
        return (x() * x() + y() * y());
    }
    
    public void normalize()
    {
        float f = (float) (1.0/length());
        set(x()*f,y()*f);
    }
    
    public Double angle(Vector2d v)
    {
        double d = dot(v)/(length()*v.length());
        
        if(d < -1.0)
        {
            d = -1.0;
        }
        
        if(d > 1.0)
        {
            d = 1.0;
        }
        return Math.acos(d);
    }
    
    public void normalize(Vector2d v)
    {
        double f = (1.0/Math.sqrt(v.x()*v.x()+y()*y()));
        set(v.x()*f,v.y()*f);
    }
    
    public Double dot(Vector2d v)
    {
        return this.x()*v.x()+this.y()*v.y();
    }
    
    public Double length()
    {
        return Math.sqrt(x() * x() + y() * y());
    }
}