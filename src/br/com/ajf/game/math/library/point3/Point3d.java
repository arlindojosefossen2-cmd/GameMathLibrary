package br.com.ajf.game.math.library.point3;

import br.com.ajf.game.math.library.point4.IPoint4;

public class Point3d extends Point3<Double>
{
    public Point3d()
    {
        this(0.0,0.0,0.0);
    }
    
    public Point3d(double x, double y, double z)
    {
        super(x,y,z);
    }
    
    public Point3d(double[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Point3d(IPoint3<Double> p)
    {
        super(p);
    }
    
    @Override
    public void set(Double x, Double y, Double z)
    {
        setX(x);
        setY(y);
        setZ(z);
    }
    
    @Override
    public void set(IPoint3<Double> p)
    {
        set(p.x(),p.y(),p.z());
    }
    
    public void set(double[] arrayPoints)
    {
        if(arrayPoints.length < 3)
        {
            return;
        }
        
        set(arrayPoints[0],arrayPoints[1],arrayPoints[2]);
    }
    
    @Override
    public void add(IPoint3<Double> p)
    {
        set(x()+p.x(),y()+p.y(),z()+p.z());
    }
    
    @Override
    public void add(IPoint3<Double> p1, IPoint3<Double> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y(),p1.z()+p2.z());
    }
    
    @Override
    public void sub(IPoint3<Double> p)
    {
        set(x()-p.x(),y()-p.y(),z()-p.z());
    }
    
    @Override
    public void sub(IPoint3<Double> p1, IPoint3<Double> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y(),p1.z()-p2.z());
    }
    
    @Override
    public void negate()
    {
        set(-x(),-y(),-z());
    }
    
    @Override
    public void negate(IPoint3<Double> p)
    {
        set(-p.x(),-p.y(),-p.z());
    }
    
    @Override
    public void scale(Double n)
    {
        set(n*x(),n*y(),n*z());
    }
    
    @Override
    public void scale(Double n, IPoint3<Double> p)
    {
        set(n*p.x(),n*p.y(),n*p.z());
    }
    
    @Override
    public void scaleAndAdd(Double n, IPoint3<Double> p1, IPoint3<Double> p2)
    {
        set(n*p1.x()+p2.x(),n*p1.y()+p2.y(),n*p1.z()+p2.z());
    }
    
    @Override
    public void scaleAndAdd(Double n, IPoint3<Double> p)
    {
        set(n*x()+p.x(),n*y()+p.y(),n*z()+p.z());
    }
    
    @Override
    public void clamp(Double n1, Double n2, IPoint3<Double> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
        setZ(p.z() > n2 ? n2 : (p.z() < n1 ? n1 : p.z()));
    }
    
    @Override
    public void clampMin(Double n, IPoint3<Double> p)
    {
        setX(p.x() < n ? n : p.x());
        setY(p.y() < n ? n : p.y());
        setZ(p.z() < n ? n : p.z());
    }
    
    @Override
    public void clampMax(Double n, IPoint3<Double> p)
    {
        setX(p.x() > n ? n : p.x());
        setY(p.y() > n ? n : p.y());
        setZ(p.z() > n ? n : p.z());
    }
    
    @Override
    public void absolute()
    {
        set(Math.abs(x()),Math.abs(y()),Math.abs(z()));
    }
    
    @Override
    public void absolute(IPoint3<Double> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()),Math.abs(p.z()));
    }
    
    @Override
    public void clamp(Double n1, Double n2)
    {
        if(x() > n2)
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
        
        if(z() > n2)
        {
            setZ(n2);
        }
        else if(z() < n1)
        {
            setZ(n1);
        }
    }
    
    public double distanceSquared(IPoint3<Double> p)
    {
        double f = x()-p.x();
        double f2 = y()-p.y();
        double f3 = z()-p.z();
        return f*f+f2*f2+f3*f3;
    }
    
    public double distance(IPoint3<Double> p)
    {
        return Math.sqrt(distanceSquared(p));
    }
    
    public double distanceL1(IPoint3<Double> p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y())+Math.abs(z()-p.z());
    }
    public double distanceLinF(IPoint3<Double> p)
    {
        double f = Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
        return Math.max(f,Math.abs(z()-p.z()));
    }
    
    public void project(IPoint4<Double> p)
    {
        double f  = 1.0/p.w();
        setX(p.x()*f);
        setY(p.y()*f);
        setZ(p.z()*f);
    }
    
    public void interpolate(IPoint3<Double> p1,IPoint3<Double> p2,double f)
    {
        setX((1.0f-f)*p1.x()+f*p2.x());
        setY((1.0f-f)*p1.y()+f*p2.y());
        setZ((1.0f-f)*p1.z()+f*p2.z());
    }
    
    public void interpolate(IPoint3<Double> p,double f)
    {
        setX((1.0f-f)*x()+f*p.x());
        setY((1.0f-f)*y()+f*p.y());
        setZ((1.0f-f)*z()+f*p.z());
    }
    
    public boolean epsilonEquals(IPoint3<Double> p,double f)
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
        
        if(f4 > f)
        {
            return false;
        }
        
        f2 = z()-p.z();
        
        if(Double.isNaN(f2))
        {
            return false;
        }
        
        double f5 = f2 < 0.0f ? -f2 : f2;
        return !(f5 > f);
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
        
        if(z() < n)
        {
            setZ(n);
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
        
        if(z() > n)
        {
            setZ(n);
        }
    }
}