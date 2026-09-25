package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4d;

public class Vector4d extends Point4d
{
    public Vector4d()
    {
    }
    
    public Vector4d(double x, double y, double z, double w)
    {
        super(x, y, z, w);
    }
    
    public Vector4d(double[] arrayPoints)
    {
        super(arrayPoints);
    }
    
    public Vector4d(Double x, Double y, Double z, Double w)
    {
        super(x, y, z, w);
    }
    
    public Vector4d(IPoint4<Double,Double,Double,Double> p)
    {
        super(p);
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
    
    public double angle(Vector4d v)
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
    
    public double dot(Vector4d v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z()+w()*v.w();
    }
    
    public double length()
    {
        return Math.sqrt(lengthSquared());
    }
    
    public double lengthSquared()
    {
        return x()*x()+y()*y()+z()*z()+w()*w();
    }
    
    public void set(IPoint3<Double,Double,Double> p)
    {
        set(p.x(),p.y(),p.z(),0.0);
    }
}