package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4d;

public class Vector4d extends Point4d
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
    
    public Vector4d(Vector4d v)
    {
        this(v.x(),v.y(),v.z(),v.w());
    }
    
    public void normalize(Vector4d v)
    {
        double f = (1.0/Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z()+v.w()*v.w()));
        set(v.x()*f,v.y()*f,v.z()*f,v.w()*f);
    }
    
    public void normalize()
    {
        double f =(1.0/Math.sqrt(x()*x()+y()*y()+z()*z()+w()*w()));
        set(x()*f,y()*f,z()*f,w()*f);
    }
    
    public Double angle(Vector4d v)
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
    
    public Double dot(Vector4d v)
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
    
    public Double distanceSquared(Vector4d p)
    {
        double f = x()-p.x();
        double f2 = y()-p.y();
        double f3 = z()-p.z();
        double f4 = w()-p.w();
        return f*f+f2*f2+f3*f3+f4*f4;
    }
    
    public Double distance(Vector4d p)
    {
        return Math.sqrt(distanceSquared(p));
    }
    
    public Double distanceL1(Vector4d p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y())+Math.abs(z()-p.z())+Math.abs(w()-p.w());
    }
    
    public Double distanceLinF(Vector4d p)
    {
        double f = Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
        double f2 = Math.max(Math.abs(z()-p.z()),Math.abs(w()-p.w()));
        return Math.max(f,f2);
    }
    
    public void project(Vector4d p)
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
}