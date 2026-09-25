package br.com.ajf.game.math.library.vector2;

import br.com.ajf.game.math.library.point2.IPoint2;
import br.com.ajf.game.math.library.point2.Point2;

public final class Vector2d extends Vector2<Double,Double>
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
    
    public Double angle(IVector2<Double,Double> v)
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
    
    public void normalize(IVector2<Double,Double> v)
    {
        double f = (1.0/Math.sqrt(v.x()*v.x()+y()*y()));
        set(v.x()*f,v.y()*f);
    }
    
    public Double dot(IVector2<Double,Double> v)
    {
        return this.x()*v.x()+this.y()*v.y();
    }
    
    public Double length()
    {
        return Math.sqrt(x() * x() + y() * y());
    }
    
    public Double distanceSquared(IPoint2<Double,Double> p)
    {
        double f = x()-p.x();
        double f2 = y()-p.y();
        return f*f+f2*f2;
    }
    
    public Double distance(IPoint2<Double,Double> p)
    {
        return Math.sqrt(distanceSquared(p));
    }
    
    public Double distanceL1(IPoint2<Double,Double> p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y());
    }
    
    public Double distanceLinF(IPoint2<Double,Double> p)
    {
        return Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
    }
    
    @Override
    public void set(Double x, Double y)
    {
        setX(x);
        setY(y);
    }
    
    @Override
    public void set(IPoint2<Double,Double> p)
    {
        set(p.x(),p.y());
    }
    
    @Override
    public void clampMin(Double n)
    {
        if(x() < n)
        {
            setX(n);
        }
        
        if(y() < n)
        {
            setY(n);
        }
    }
    
    @Override
    public void clampMax(Double n)
    {
        if(x() > n)
        {
            setX(n);
        }
        
        if(y() > n)
        {
            setY(n);
        }
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
    public void clamp(Double n1, Double n2, IPoint2<Double,Double> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1) ? n1 : p.x());
        setY(p.y() > n2 ? n2 : (p.y() < n1) ? n1 : p.y());
    }
    
    @Override
    public void clampMin(Double n, IPoint2<Double,Double> p)
    {
        setX(p.x() < n ? n : p.x());
        setY(p.y() < n ? n : p.y());
    }
    
    @Override
    public void clampMax(Double n, IPoint2<Double,Double> p)
    {
        setX(p.x() > n ? n : p.x());
        setY(p.y() > n ? n : p.y());
    }
    
    @Override
    public void absolute(IPoint2<Double,Double> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()));
    }
    
    @Override
    public void absolute()
    {
        set(Math.abs(x()),Math.abs(y()));
    }
    
    @Override
    public void negate()
    {
        setX(-x());
        setY(-y());
    }
    
    @Override
    public void negate(IPoint2<Double,Double> p)
    {
        setX(-p.x());
        setY(-p.y());
    }
    
    @Override
    public void add(IPoint2<Double,Double> p)
    {
        setX(x()+p.x());
        setY(y()+p.y());
    }
    
    @Override
    public void add(IPoint2<Double,Double> p1, IPoint2<Double,Double> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y());
    }
    
    @Override
    public void add(Double x, Double y)
    {
        set(x+x(),y+y());
    }
    
    @Override
    public void sub(IPoint2<Double,Double> p)
    {
        setX(x()-p.x());
        setY(y()-p.y());
    }
    
    @Override
    public void sub(IPoint2<Double,Double> p1, IPoint2<Double,Double> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y());
    }
    
    @Override
    public void sub(Double x, Double y)
    {
        set(x-x(),y-y());
    }
    
    @Override
    public void multiply(IPoint2<Double,Double> p)
    {
        setX(x()*p.x());
        setY(y()*p.y());
    }
    
    public void interpolate(IPoint2<Double,Double> p,Double n)
    {
        setX((1.0f-n)*x()+n*p.x());
        setY((1.0f-n)*y()+n*p.y());
    }
    
    public void interpolate(IPoint2<Double,Double> p1,IPoint2<Double,Double> p2,Double n)
    {
        setX((1.0f-n)*p1.x()+n*p2.x());
        setY((1.0f-n)*p1.y()+n*p2.y());
    }
    
    public boolean epsilonEquals(IPoint2<Double,Double> p,Double f)
    {
        double f2 = x()-p.x();
        
        if(Double.isNaN(f2))
        {
            return false;
        }
        
        double f3 = f2 < 0.0f ? -f2 : f2;
        if(f3 > f)
        {
            return false;
        }
        
        f2 = y()-p.y();
        
        if(Double.isNaN(f2))
        {
            return false;
        }
        
        double f4 = f2 < 0.0f ? -f2 : f2;
        return !(f4 > f);
    }
    
    @Override
    public void divide(IPoint2<Double,Double> p)
    {
        if(p.x() == 0.0 || p.y() == 0.0)
        {
            return;
        }
        
        setX(x()/p.x());
        setY(y()/p.y());
    }
    
    @Override
    public void scale(Double n)
    {
        set(x()*n,y()*n);
    }
    
    @Override
    public void scale(IPoint2<Double,Double> p, Double n)
    {
        set(p.x()*n,y()*n);
    }
    
    @Override
    public void scaleAndAdd(IPoint2<Double,Double> p, Double n)
    {
        set(n*x()+p.x(),n*y()+p.y());
    }
    
    @Override
    public void scaleAndAdd(IPoint2<Double,Double> p1, IPoint2<Double,Double> p2, Double n)
    {
        set(n*p1.x()+ p2.x(),n*p1.y()+p2.y());
    }
}