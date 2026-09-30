package br.com.ajf.game.math.library.vector3;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point3.Point3f;

public class Vector3f extends Point3f
{
    public Vector3f()
    {
        this(0f,0f,0f);
    }
    
    public Vector3f(float x, float y, float z)
    {
        super(x, y, z);
    }
    
    public Vector3f(float[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Vector3f(IPoint3<Float> p)
    {
        super(p);
    }
    
    public Vector3f(Vector3f v)
    {
        this(v.x(),v.y(),v.z());
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
    
    public Float angle(Vector3f v)
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
    
    public Float lengthSquared()
    {
        return x()*x()+y()*y()+z()*z();
    }
    
    public Float length()
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
    
    public Float dot(Vector3f v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z();
    }
}