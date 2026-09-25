package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.vector3.IVector3;

public class Vector4d extends Vector4<Double,Double,Double,Double>
{
    public Vector4d()
    {
        this(0,0,0,0);
    }
    
    public Vector4d(double x, double y, double z, double w)
    {
        super(x, y, z, w);
    }
    
    public Vector4d(Double[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Vector4d(IPoint4<Double,Double,Double,Double> p)
    {
        super(p);
    }
    
    public void normalize(IVector4<Double,Double,Double,Double> v)
    {
        double f = (1.0/Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z()+v.w()*v.w()));
        set(v.x()*f,v.y()*f,v.z()*f,v.w()*f);
    }
    
    public void normalize()
    {
        double f =(1.0/Math.sqrt(x()*x()+y()*y()+z()*z()+w()*w()));
        set(x()*f,y()*f,z()*f,w()*f);
    }
    
    public Double angle(IVector4<Double,Double,Double,Double> v)
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
    
    public Double dot(IVector4<Double,Double,Double,Double> v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z()+w()*v.w();
    }
    
    public Double length()
    {
        return Math.sqrt(lengthSquared());
    }
    
    public Double lengthSquared()
    {
        return x()*x()+y()*y()+z()*z()+w()*w();
    }
    
    public void set(IPoint3<Double,Double,Double> p)
    {
        set(p.x(),p.y(),p.z(),0.0);
    }
    
    public void set(IVector3<Double,Double,Double> p)
    {
        set(p.x(),p.y(),p.z(),1.0);
    }
    
    public Double distanceSquared(IVector4<Double,Double,Double,Double> p)
    {
        double f = x()-p.x();
        double f2 = y()-p.y();
        double f3 = z()-p.z();
        double f4 = w()-p.w();
        return f*f+f2*f2+f3*f3+f4*f4;
    }
    
    public Double distance(IVector4<Double,Double,Double,Double> p)
    {
        return Math.sqrt(distanceSquared(p));
    }
    
    public Double distanceL1(IVector4<Double,Double,Double,Double> p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y())+Math.abs(z()-p.z())+Math.abs(w()-p.w());
    }
    
    public Double distanceLinF(IVector4<Double,Double,Double,Double> p)
    {
        double f = Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
        double f2 = Math.max(Math.abs(z()-p.z()),Math.abs(w()-p.w()));
        return Math.max(f,f2);
    }
    
    public void project(IVector4<Double,Double,Double,Double> p)
    {
        double f = 1.0/p.w();
        setX(p.x()*f);
        setY(p.y()*f);
        setZ(p.z()*f);
        setW(1.0);
    }
    
    public void set(Double[] array)
    {
        if(array.length < 4)
        {
            return;
        }
        
        set(array[0],array[1],array[2],array[3]);
    }
    
    public double[] get()
    {
        return new double[]{x(),y(),z(),w()};
    }
    
    @Override
    public void set(Double x, Double y, Double z, Double w)
    {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }
    
    @Override
    public void set(IPoint4<Double,Double,Double,Double> p)
    {
        set(p.x(),p.y(),p.z(),p.w());
    }
    
    @Override
    public void add(IPoint4<Double,Double,Double,Double> p)
    {
        set(x()+p.x(),y()+p.y(),z()+p.z(),w()+p.w());
    }
    
    @Override
    public void add(IPoint4<Double,Double,Double,Double> p1, IPoint4<Double,Double,Double,Double> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y(),p1.z()+p2.z(),p1.w()+p2.w());
    }
    
    @Override
    public void sub(IPoint4<Double,Double,Double,Double> p)
    {
        set(x()-p.x(),y()-p.y(),z()-p.z(),w()-p.w());
    }
    
    @Override
    public void sub(IPoint4<Double,Double,Double,Double> p1, IPoint4<Double,Double,Double,Double> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y(),p1.z()-p2.z(),p1.w()-p2.w());
    }
    
    public void interpolate(IPoint4<Double,Double,Double,Double> p,double f)
    {
        setX((1.0f-f)*x()+f*p.x());
        setY((1.0f-f)*y()+f*p.y());
        setZ((1.0f-f)*z()+f*p.z());
        setW((1.0f-f)*w()+f*p.w());
    }
    
    public void interpolate(IPoint4<Double,Double,Double,Double> p1,IPoint4<Double,Double,Double,Double> p2,double f)
    {
        setX((1.0f-f)*p1.x()+f*p2.x());
        setY((1.0f-f)*p1.y()+f*p2.y());
        setZ((1.0f-f)*p1.z()+f*p2.z());
        setW((1.0f-f)*p1.w()+f*p2.w());
    }
    
    public boolean epsilonEquals(IPoint4<Double,Double,Double,Double> p,double f)
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
        
        if(f5 > f)
        {
            return false;
        }
        
        f2 = w()-p.w();
        
        if(Double.isNaN(f2))
        {
            return false;
        }
        
        double f6 = f2 < 0.0f ? -f2 : f2;
        
        return !(f6 > f);
    }
    
    @Override
    public void negate()
    {
        set(-x(),-y(),-z(),-w());
    }
    
    @Override
    public void negate(IPoint4<Double,Double,Double,Double> p)
    {
        set(-p.x(),-p.y(),-p.z(),-p.w());
    }
    
    @Override
    public void scale(Double n)
    {
        set(x()*n,y()*n,z()*n,w()*n);
    }
    
    @Override
    public void scale(Double n, IPoint4<Double,Double,Double,Double> p)
    {
        set(n*p.x(),n*p.y(),n*p.z(),n*p.w());
    }
    
    @Override
    public void scaleAndAdd(Double n, IPoint4<Double,Double,Double,Double> p)
    {
        setX(n*x()+p.x());
        setY(n*y()+p.y());
        setZ(n*z()+p.z());
        setW(n*w()+p.w());
    }
    
    @Override
    public void scaleAndAdd(Double n, IPoint4<Double,Double,Double,Double> p1, IPoint4<Double,Double,Double,Double> p2)
    {
        setX(n*p1.x()+p2.x());
        setY(n*p1.y()+p2.y());
        setZ(n*p1.z()+p2.z());
        setW(n*p1.w()+p2.w());
    }
    
    @Override
    public void clamp(Double n1, Double n2, IPoint4<Double,Double,Double,Double> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
        setZ(p.z() > n2 ? n2 : (p.z() < n1 ? n1 : p.z()));
        setW(p.w() > n2 ? n2 : (p.w() < n1 ? n1 : p.w()));
    }
    
    @Override
    public void clampMin(Double n, IPoint4<Double,Double,Double,Double> p)
    {
        setX((p.x() < n ? n : p.x()));
        setY((p.y() < n ? n : p.y()));
        setZ((p.z() < n ? n : p.z()));
        setW((p.w() < n ? n : p.w()));
    }
    
    @Override
    public void clampMax(Double n, IPoint4<Double,Double,Double,Double> p)
    {
        setX((p.x() > n ? n : p.x()));
        setY((p.y() > n ? n : p.y()));
        setZ((p.z() > n ? n : p.z()));
        setW((p.w() > n ? n : p.w()));
    }
    
    @Override
    public void absolute()
    {
        set(Math.abs(x()),Math.abs(y()),Math.abs(z()),Math.abs(w()));
    }
    
    @Override
    public void absolute(IPoint4<Double,Double,Double,Double> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()),Math.abs(p.z()),Math.abs(p.w()));
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
        
        if(w() > n2)
        {
            setW(n2);
        }
        else if(w() < n1)
        {
            setW(n1);
        }
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
        
        if(w() < n)
        {
            setW(n);
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
        
        if(w() > n)
        {
            setW(n);
        }
    }
}