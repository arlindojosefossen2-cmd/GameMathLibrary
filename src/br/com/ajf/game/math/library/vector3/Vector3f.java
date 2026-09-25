package br.com.ajf.game.math.library.vector3;

import br.com.ajf.game.math.library.point3.Point3;
import br.com.ajf.game.math.library.point3.Point3f;

public class Vector3f extends Point3f
{
    public Vector3f()
    {
    }
    
    public Vector3f(float x, float y, float z)
    {
        super(x, y, z);
    }
    
    public Vector3f(float[] arrayPoints)
    {
        super(arrayPoints);
    }
    
    public Vector3f(Float x, Float y, Float z)
    {
        super(x, y, z);
    }
    
    public Vector3f(Point3<Float, Float, Float> p)
    {
        super(p);
    }
    
    public void normalize(Vector3f v)
    {
        float f = (float) (1.0/Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z()));
        set(v.x()*f,v.y()*f,v.z()*f);
    }
    
    public void normalize()
    {
        float f = (float) (1.0/Math.sqrt(x()*x()+y()*y()+z()*z()));
        set(x()*f,y()*f,z()*f);
    }
    
    public float angle(Vector3f v)
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
        
        return (float) Math.acos(d);
    }
    
    public float lengthSquared()
    {
        return x()*x()+y()*y()+z()*z();
    }
    
    public float length()
    {
        return (float) Math.sqrt(lengthSquared());
    }
    
    public void cross(Vector3f v,Vector3f u)
    {
        float f = v.y()*u.z()-v.z()*u.y();
        float f2 = u.x()*v.z()-u.z()*v.x();
        setZ(v.x()*u.y()-v.y()*u.x());
        setX(f);
        setY(f2);
    }
    
    public float dot(Vector3f v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z();
    }
}