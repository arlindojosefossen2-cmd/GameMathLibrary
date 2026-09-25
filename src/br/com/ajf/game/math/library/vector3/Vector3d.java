package br.com.ajf.game.math.library.vector3;

import br.com.ajf.game.math.library.point3.Point3;
import br.com.ajf.game.math.library.point3.Point3d;

public class Vector3d extends Point3d
{
    public Vector3d()
    {
    }
    
    public Vector3d(double x,double y,double z)
    {
        super(x, y, z);
    }
    
    public Vector3d(double[] arrayPoints)
    {
        super(arrayPoints);
    }
    
    public Vector3d(Double x, Double y, Double z)
    {
        super(x, y, z);
    }
    
    public Vector3d(Point3<Double,Double,Double> p)
    {
        super(p);
    }
    
    public void normalize(Vector3d v)
    {
        double f = (1.0/Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z()));
        set(v.x()*f,v.y()*f,v.z()*f);
    }
    
    public void normalize()
    {
        double f = (1.0/Math.sqrt(x()*x()+y()*y()+z()*z()));
        set(x()*f,y()*f,z()*f);
    }
    
    public double angle(Vector3d v)
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
    
    public double lengthSquared()
    {
        return x()*x()+y()*y()+z()*z();
    }
    
    public double length()
    {
        return Math.sqrt(lengthSquared());
    }
    
    public void cross(Vector3d v, Vector3d u)
    {
        double f = v.y()*u.z()-v.z()*u.y();
        double f2 = u.x()*v.z()-u.z()*v.x();
        setZ(v.x()*u.y()-v.y()*u.x());
        setX(f);
        setY(f2);
    }
    
    public double dot(Vector3d v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z();
    }
}